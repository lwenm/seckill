package com.blackface.seckill.redis.prefix;


import com.blackface.seckill.redis.BasicPrefix;

/**
 * Author:lwenm
 * Description:
 * Date:2019/3/19
 * Time:14:58
 **/
public class City extends BasicPrefix {

    private City(String prefix) {
        super(0, prefix);
    }

    private City(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static City getByCityName = new City("visits_");

}
