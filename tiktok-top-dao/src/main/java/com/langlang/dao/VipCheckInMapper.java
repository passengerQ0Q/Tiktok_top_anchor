package com.langlang.dao;

import com.langlang.domain.VipCheckIn;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VipCheckInMapper {
    int insert(VipCheckIn vipCheckIn);

    VipCheckIn selectByPhone(Integer phone);

    int updateByPhone(VipCheckIn record);
}