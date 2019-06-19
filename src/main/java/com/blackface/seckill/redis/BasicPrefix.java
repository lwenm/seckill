package com.blackface.seckill.redis;

/**
 * Author:lwenm
 * Description: 前缀基础类
 * Date:2018/12/24
 * Time:23:06
 **/
public class BasicPrefix implements KeyPrefix {

    private int expireSeconds;

    private String prefix;

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }

    public BasicPrefix(String prefix) {
        this(0, prefix);
    }

    public BasicPrefix(int expireSeconds, String prefix) {

        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }
}
