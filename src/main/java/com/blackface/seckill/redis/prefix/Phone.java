package com.blackface.seckill.redis.prefix;


import com.blackface.seckill.redis.BasicPrefix;

/**
 * Author:lwenm
 * Description: 手机号码段
 * Date:2019/3/19
 * Time:9:57
 **/
public class Phone  extends BasicPrefix {

    private Phone(String prefix) {
        super(0, prefix);
    }

    private Phone(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static Phone getByFirstSEV = new Phone("SEV_");

}
