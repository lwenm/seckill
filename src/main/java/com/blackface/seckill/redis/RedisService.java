package com.blackface.seckill.redis;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Author:lwenm
 * Description: redisService
 * Date:2018/12/24
 * Time:21:59
 **/

@Service
@Slf4j
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 获取单个对象
     * @param prefix  键前缀
     * @param key 键
     * @param clazz  值对象类型
     * @param <T> 类型
     * @return 返回值
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(prefix.getPrefix() + key);
            T t = stringToBean(value, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }

    }

    /**
     *  对象存储
     * @param prefix 前缀
     * @param key  键
     * @param value 值
     * @param <T>  值类型
     * @return   返回值
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String valueStr = beanToString(value);
            String realKey = prefix.getPrefix() + key;
            int expireSeconds = prefix.expireSeconds();
            String s = "";
            if (expireSeconds <= 0) {
                s = jedis.set(realKey, valueStr);
            } else {
                s = jedis.setex(realKey, expireSeconds, valueStr);
            }
            log.info("result {}", s);

            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 判断是否存在key
     * @param prefix 前缀
     * @param key  键
     * @return   返回值
     */
    public boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(prefix.getPrefix() + key);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 给Key-valu重置寿命
     * @param prefix 前缀
     * @param key  键
     * @return   返回值
     */
    public Long expireForSeconds(KeyPrefix prefix, String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.expire(realKey, seconds);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     *  值减一
     * @param prefix 前缀
     * @param key 键
     * @return 返回值
     */
    public Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     *  值加一
     * @param prefix 前缀
     * @param key 键
     * @return 返回值
     */
    public Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     *
     * @param value T对象
     * @param <T>  类型
     * @return  对象字符串
     */
    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    /**
     *
     * @param value 字符串参数
     * @param clazz  对象类型
     * @param <T>  类型
     * @return  t类型对象
     */
    public static <T> T stringToBean(String value, Class<T> clazz) {
        if (value == null || value.length() == 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(value);
        } else if (clazz == String.class) {
            return (T) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(value);
        } else {
            return JSON.toJavaObject(JSON.parseObject(value), clazz);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 模糊匹配 获取keys集合
     * @param pattern 匹配字串
     * @return Set<String>
     */
    public Set<String> keys(String pattern) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return  jedis.keys(pattern);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 完整key 获取value
     * @param key key
     * @return String
     */
    public String  getString(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return  jedis.get(key);
        } finally {
            returnToPool(jedis);
        }
    }

}
