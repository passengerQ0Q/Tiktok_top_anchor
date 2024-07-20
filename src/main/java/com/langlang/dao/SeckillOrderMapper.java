package com.langlang.dao;

import com.langlang.domain.SeckillOrder;

public interface SeckillOrderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);
}