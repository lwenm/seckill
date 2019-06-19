package com.blackface.seckill.service;

import com.blackface.seckill.domain.OrderInfo;
import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.vo.SecKillGoodsVo;

/**
 * Author:lwenm
 * Description: 秒杀servcie
 * Date:2019/5/27
 * Time:21:29
 **/
public interface SecKillService {

    /**
     * 进行商品的秒杀
     * @param user
     * @param goodsVo
     * @return
     */
    OrderInfo kill(SecUser user, SecKillGoodsVo goodsVo);
}
