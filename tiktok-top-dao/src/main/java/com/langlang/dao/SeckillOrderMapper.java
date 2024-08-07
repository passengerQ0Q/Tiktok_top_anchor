package com.langlang.dao;

import com.langlang.domain.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillOrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);
}