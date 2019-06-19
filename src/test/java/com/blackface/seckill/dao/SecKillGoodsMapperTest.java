package com.blackface.seckill.dao;

import com.blackface.seckill.vo.SecKillGoodsVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/21
 * Time:23:24
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecKillGoodsMapperTest {


    @Autowired
    SecKillGoodsMapper goodsMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }


    @Test
    public void getSecKillGoods() throws Exception {

        SecKillGoodsVo goodsVo = goodsMapper.getSecKillGoods(1);
        Assert.assertNotNull(goodsVo);
    }

    @Test
    public void getSecKillGoodsList() throws Exception {
        List<SecKillGoodsVo> result = goodsMapper.getSecKillGoodsList();
        for (SecKillGoodsVo s:result) {
            System.out.println(s.toString());
        }
        Assert.assertNotNull(result);

    }

    @Test
    public void reduceStock() throws Exception {

        goodsMapper.reduceStock(1L);
    }


}