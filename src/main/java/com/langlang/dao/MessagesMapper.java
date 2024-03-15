package com.langlang.dao;

import com.langlang.domain.Messages;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MessagesMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("createdTime") Date createdTime);

    int insert(Messages record);

    List<Messages> queryByVip(Messages  record);
    Messages queryByVipOne(Messages  record);

}