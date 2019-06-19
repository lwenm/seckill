package com.blackface.seckill.service.impl;

import com.blackface.seckill.dao.SecKillGoodsMapper;
import com.blackface.seckill.service.GoodsService;
import com.blackface.seckill.vo.SecKillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/22
 * Time:21:48
 **/
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    SecKillGoodsMapper secKillGoodsMapper;

    @Override
    public List<SecKillGoodsVo> getSecKillGoodsList() {
        return secKillGoodsMapper.getSecKillGoodsList();
    }

    @Override
    public SecKillGoodsVo getSecKillGoods(long id) {
        return secKillGoodsMapper.getSecKillGoods(id);
    }

    @Override
    public void reduceStock(SecKillGoodsVo goodsVo) {

        secKillGoodsMapper.reduceStock(goodsVo.getSecId());
    }
}
