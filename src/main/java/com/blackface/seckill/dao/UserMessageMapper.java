package com.blackface.seckill.dao;

import com.blackface.seckill.domain.UserMessage;

public interface UserMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}