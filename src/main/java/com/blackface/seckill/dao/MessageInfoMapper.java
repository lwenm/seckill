package com.blackface.seckill.dao;

import com.blackface.seckill.domain.MessageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface MessageInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageInfo record);

    int insertSelective(MessageInfo record);

    MessageInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageInfo record);

    int updateByPrimaryKey(MessageInfo record);
}