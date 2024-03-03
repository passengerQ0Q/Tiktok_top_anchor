package com.langlang.dao;

import com.langlang.domain.Anchors;

public interface AnchorsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Anchors record);

    Anchors selectByPrimaryKey(Integer phone);


    int updateByPrimaryKey(Anchors record);
}