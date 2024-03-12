package com.langlang.controller;


import com.langlang.dao.UserMapper;
import com.langlang.domain.Anchors;
import com.langlang.domain.User;
import com.langlang.domain.Users;
import com.langlang.request.RechargeReq;
import com.langlang.response.AnchorsRsp;
import com.langlang.utils.RedisUtil;
import com.langlang.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController()
public class RechargeController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;
    /**
     * 充值1000 DouJia
     * @param req
     * @return
     */
    @RequestMapping("recharge1000DouJia")
    public Result<String> recharge1000DouJia(@RequestBody RechargeReq req){

        if(req.getMoney() == null || req.getPhone() == null || StringUtils.isAnyBlank(req.getPassword())){
            return Result.fail("参数为空，请检查参数");
        }
        AnchorsRsp anchors = new AnchorsRsp();
        anchors.setPhone(req.getPhone());
        anchors.setUpdatedAt(new Date());
        //更新缓存数据

        redisTemplate.opsForList().rightPushAll("top100AnchorsList", Arrays.asList(anchors));

        //查询用户有多少金额
        User userInfo = userMapper.getUserInfo(req.getPhone());
        User user = new User();
        user.setPhone(req.getPhone());
        //用户账户加1000
        user.setDouJia(userInfo.getDouJia() + 1000);
        //更新数据库的用户金额
        userMapper.updateUserInfo(user);

        return Result.success(req.getMoney() + "元充值成功，您已展示在主播首页前100名，请刷新页面查看");
    }

}
