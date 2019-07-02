package com.blackface.seckill.service;

import com.blackface.seckill.domain.OrderInfo;
import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.vo.SecKillGoodsVo;

/**
 * Author:lwenm
 * Description: 秒杀服务类
 * Date:2019/5/27
 * Time:21:15
 **/

public interface OrderService {

    /**
     * 根据用户Id和商品Id查询订单
     * @param userId
     * @param OrderId
     * @return
     */
    OrderInfo getOrderInfoByUserIdAndGoodId(Long userId, Long OrderId);

    /**
     * 生成订单
     * @param user
     * @param goodsVo
     * @return
     */
    OrderInfo createOrder(SecUser user, SecKillGoodsVo goodsVo);
}
