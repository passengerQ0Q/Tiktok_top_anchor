package com.langlang.service;

import com.langlang.dao.VipCheckInMapper;
import com.langlang.domain.VipCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VipCheckInServiceImpl implements VipCheckInService {

    @Autowired
    private VipCheckInMapper vipCheckInMapper;

    @Override
    public int insert(VipCheckIn vipCheckIn) {
        return vipCheckInMapper.insert(vipCheckIn);

    }

    @Override
    public VipCheckIn selectByPhone(Integer phone) {
        return vipCheckInMapper.selectByPhone(phone);
    }

    @Override
    public int updateByPhone(VipCheckIn record) {
        return vipCheckInMapper.updateByPhone(record);
    }
}
