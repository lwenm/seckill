package com.blackface.seckill.service.impl;

import com.blackface.seckill.dao.OrderInfoMapper;
import com.blackface.seckill.dao.SecKillOrderMapper;
import com.blackface.seckill.domain.OrderInfo;
import com.blackface.seckill.domain.SecKillOrder;
import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.service.OrderService;
import com.blackface.seckill.vo.SecKillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/27
 * Time:21:22
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private SecKillOrderMapper killOrderMapper;

    @Override
    public OrderInfo getOrderInfoByUserIdAndGoodId(Long userId, Long goodsId) {
        return orderInfoMapper.selectByGoodsIdAndUserId(userId, goodsId);
    }

    @Override
    public OrderInfo createOrder(SecUser user, SecKillGoodsVo goodsVo) {

        OrderInfo orderInfo  = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goodsVo.getId());
        orderInfo.setGoodsName(goodsVo.getGoodsName());
        orderInfo.setGoodsPrice(goodsVo.getSeckillPrice());
        orderInfo.setUserId(user.getId());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);

        long orderId = orderInfoMapper.insert(orderInfo);

        SecKillOrder killOrder = new SecKillOrder();
        killOrder.setGoodsId(goodsVo.getSecId());
        killOrder.setOrderId(orderId);
        killOrder.setUserId(user.getId());
        killOrderMapper.insert(killOrder);

        return orderInfo;
    }
}
