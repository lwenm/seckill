package com.blackface.seckill.service.impl;

import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.domain.OrderInfo;
import com.blackface.seckill.service.SecKillService;
import com.blackface.seckill.vo.SecKillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/27
 * Time:21:29
 **/
@Service
public class SecKillServiceImpl implements SecKillService {



    @Autowired
    GoodsServiceImpl goodsService;

    @Autowired
    OrderServiceImpl orderService;

    @Override
    @Transactional
    public OrderInfo kill(SecUser user, SecKillGoodsVo goodsVo) {


        //减少库存
        goodsService.reduceStock(goodsVo);

        //生成订单
        return  orderService.createOrder(user,goodsVo);


    }
}
