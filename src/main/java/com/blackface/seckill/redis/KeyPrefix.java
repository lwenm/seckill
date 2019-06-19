package com.blackface.seckill.redis;

/**
 * Author:lwenm
 * Description:
 * Date:2018/12/24
 * Time:22:01
 **/
public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();

}
