package com.langlang.controller;

import com.langlang.domain.VipCheckIn;
import com.langlang.service.VipCheckInService;
import com.langlang.utils.Result;
import com.langlang.utils.TimeUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.langlang.utils.TimeUtils.get30DaysAgo;


@RestController
public class VipCheckInController {

    @Autowired
    private VipCheckInService vipCheckInService;


    @RequestMapping("checkIn")
    public Result<String> checkIn(Integer phone) {
        Date now = new Date();
        VipCheckIn vipCheckIn = vipCheckInService.selectByPhone(phone);

        if (now.after(TimeUtils.get30DaysAgo(vipCheckIn.getCreatedAt()))) {
            return Result.fail("签到失败，已超过签到时间");
        }
        if (vipCheckIn == null) {
            vipCheckIn = new VipCheckIn();
            vipCheckIn.setPhone(phone);
            vipCheckIn.setCheckNum(1);
            vipCheckIn.setCreatedAt(now);
            vipCheckIn.setUpdatedAt(now);
            vipCheckIn.setIsPass(1);
            vipCheckInService.insert(vipCheckIn);
        } else {
            vipCheckIn = new VipCheckIn();
            vipCheckIn.setPhone(phone);
            vipCheckIn.setCheckNum(vipCheckIn.getCheckNum() + 1);
            vipCheckIn.setCreatedAt(now);
            vipCheckIn.setUpdatedAt(now);
            vipCheckIn.setIsPass(1);
            vipCheckInService.updateByPhone(vipCheckIn);
        }
        return Result.success("签到成功");
    }



}
