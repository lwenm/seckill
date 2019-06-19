package com.blackface.seckill.dao;

import com.blackface.seckill.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
}