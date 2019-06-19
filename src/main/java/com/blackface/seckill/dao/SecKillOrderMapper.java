package com.blackface.seckill.dao;

import com.blackface.seckill.domain.SecKillOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface SecKillOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecKillOrder record);

    int insertSelective(SecKillOrder record);

    SecKillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecKillOrder record);

    int updateByPrimaryKey(SecKillOrder record);
}