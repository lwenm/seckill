package com.blackface.seckill.service;

import com.blackface.seckill.vo.SecKillGoodsVo;

import java.util.List;

/**
 * Author:lwenm
 * Description: 商品服务类接口
 * Date:2019/5/22
 * Time:21:30
 **/
public interface GoodsService {


    /**
     * 获取商品列表
     * @return
     */
    List<SecKillGoodsVo> getSecKillGoodsList();


    /**
     * 通过id获取秒杀商品
     * @param id
     * @return
     */
    SecKillGoodsVo getSecKillGoods(long id);


    void reduceStock(SecKillGoodsVo goodsVo);

}
