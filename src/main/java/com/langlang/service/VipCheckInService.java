package com.langlang.service;

import com.langlang.domain.VipCheckIn;

public interface VipCheckInService {
    public int insert(VipCheckIn vipCheckIn);

    public VipCheckIn selectByPhone(Integer phone);

    public int updateByPhone(VipCheckIn record);
}
