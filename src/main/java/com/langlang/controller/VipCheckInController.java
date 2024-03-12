package com.langlang.controller;

import com.langlang.dao.UserMapper;
import com.langlang.domain.User;
import com.langlang.domain.VipCheckIn;
import com.langlang.service.VipCheckInService;
import com.langlang.utils.Result;
import com.langlang.utils.TimeUtils;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
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

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("checkIn")
    public Result<String> checkIn(Integer phone) {
        Date now = new Date();
        VipCheckIn vipCheckIn = vipCheckInService.selectByPhone(phone);

        if (ObjectUtils.isNotEmpty(vipCheckIn) && now.after(TimeUtils.get30DaysAgo(vipCheckIn.getCreatedAt()))) {
            return Result.fail("签到失败，已超过签到时间");
        }
        User user = userMapper.getUserInfo(phone);


        if (ObjectUtils.isEmpty(vipCheckIn)) {
            // 第一次签到,签到次数加1， 砖石数加100
            VipCheckIn vipCheckIn1 = new VipCheckIn();
            vipCheckIn1.setPhone(phone);
            vipCheckIn1.setCreatedAt(now);
            vipCheckIn1.setUpdatedAt(now);
            vipCheckIn1.setCheckNum(1);
            user.setDiamond(user.getDiamond() + 100);
            userMapper.updateUserInfo(user);
            vipCheckIn1.setIsPass(1);
            vipCheckInService.insert(vipCheckIn1);
            return Result.success("第" +vipCheckIn1.getCheckNum().toString() +"次签到成功");
        }
        if (ObjectUtils.isNotEmpty(vipCheckIn)) {
            // 计算签到次数
            int checkNum = vipCheckIn.getCheckNum();
            // 计算砖石数
            int diamondToAdd = 0;
            if (checkNum == 1) {
                diamondToAdd = 150;
            } else if (checkNum >= 2 && checkNum <= 4) {
                diamondToAdd = 200;
            } else if (checkNum == 5) {
                diamondToAdd = 300;
            } else if (checkNum == 6) {
                diamondToAdd = 500;
            }

            // 更新用户信息
            if (diamondToAdd > 0) {
                vipCheckIn.setUpdatedAt(now);
                vipCheckIn.setCheckNum(checkNum + 1);
                user.setDiamond(user.getDiamond() + diamondToAdd);
                userMapper.updateUserInfo(user);
                // 处理第7次签到特殊逻辑
                if (checkNum == 6) {
                    user.setDouJia(user.getDouJia() + 10);
                    vipCheckIn.setIsPass(0);
                }
                vipCheckInService.updateByPhone(vipCheckIn);
                return Result.success("第" + vipCheckIn.getCheckNum() + "次签到成功");
            }
        }

        return Result.success("您已签到过7天，请勿重复签到");
    }

}
