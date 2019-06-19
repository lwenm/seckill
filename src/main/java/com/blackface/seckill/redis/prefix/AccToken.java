package com.blackface.seckill.redis.prefix;

import com.blackface.seckill.redis.BasicPrefix;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/16
 * Time:21:10
 **/
public class AccToken extends BasicPrefix {


    public AccToken(String prefix) {
        super(prefix);
    }

    public AccToken(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static AccToken getToken = new AccToken(3600*24,"_");
}
