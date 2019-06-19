package com.blackface.seckill.dao;

import com.blackface.seckill.domain.SecKillGoods;
import com.blackface.seckill.vo.SecKillGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Mapper
public interface SecKillGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecKillGoods record);

    int insertSelective(SecKillGoods record);

    SecKillGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecKillGoods record);

    int updateByPrimaryKey(SecKillGoods record);

    List<SecKillGoodsVo> getSecKillGoodsList();

    SecKillGoodsVo getSecKillGoods(long id);

    void reduceStock(Long goodsId);
}