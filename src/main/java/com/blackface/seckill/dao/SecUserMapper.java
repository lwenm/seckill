package com.blackface.seckill.dao;

import com.blackface.seckill.domain.SecUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface SecUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecUser record);

    int insertSelective(SecUser record);

    SecUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecUser record);

    int updateByPrimaryKey(SecUser record);
}