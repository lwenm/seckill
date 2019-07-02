package com.blackface.seckill.dao;

import com.blackface.seckill.domain.OrderInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/27
 * Time:23:52
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoMapperTest {
    @Autowired
    OrderInfoMapper mapper;

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
    public void selectByGoodsIdAndUserId() throws Exception {
        OrderInfo orderInfo = mapper.selectByGoodsIdAndUserId(17621790399L,1L);
        Assert.assertNotNull(orderInfo);
    }

}