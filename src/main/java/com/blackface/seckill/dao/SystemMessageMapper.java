package com.blackface.seckill.dao;

import com.blackface.seckill.domain.SystemMessage;

public interface SystemMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemMessage record);

    int insertSelective(SystemMessage record);

    SystemMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemMessage record);

    int updateByPrimaryKey(SystemMessage record);
}