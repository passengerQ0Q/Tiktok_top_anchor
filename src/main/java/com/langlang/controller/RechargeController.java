package com.langlang.controller;


import com.alibaba.fastjson.JSON;
import com.langlang.dao.UserMapper;
import com.langlang.domain.Messages;
import com.langlang.domain.User;
import com.langlang.request.RechargeReq;
import com.langlang.response.AnchorsRsp;
import com.langlang.service.MessagesService;
import com.langlang.utils.Result;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

@RestController()
public class RechargeController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MessagesService messagesService;

    /**
     * 充值1000 DouJia
     *
     * @param req
     * @return
     */
    @RequestMapping("recharge1000DouJia")
    public Result<String> recharge1000DouJia(@RequestBody RechargeReq req) {

        if (req.getMoney() == null || req.getPhone() == null || StringUtils.isAnyBlank(req.getPassword())) {
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
        Messages messages = new Messages();
        messages.setPhone(req.getPhone());
        Messages msgs =  messagesService.qureyByVipOne(messages);
        kafkaTemplate.send("messages", JSON.toJSONString(msgs));
        return Result.success(req.getMoney() + "元充值成功，您已展示在主播首页前100名，请刷新页面查看");
    }

    /**
     * 充值月度会员
     *
     * @return
     */
    @RequestMapping("rechargeMonthVip")
    public Result<String> rechargeMonthVip(@RequestBody RechargeReq req) {
        if (req.getPhone() == null) {
            return Result.fail("参数为空，请检查参数");
        }
        //先查询用户数据

        User userInfo = userMapper.getUserInfo(req.getPhone());
        if (userInfo == null) {
            return Result.fail("用户不存在");
        }
        //先判断用户是否已经是会员

        User user = new User();
        user.setPhone(req.getPhone());
        user.setUpdatedAt(new Date());
        user.setDouJia(userInfo.getDouJia() + 30);
        user.setIsVip(1);
        userMapper.updateUserInfo(user);

        return Result.success("充值成功，您已经是尊贵的月度VIP用户");

    }

    /**
     * 充年度会员
     *
     * @return
     */
    @RequestMapping("rechargeYearVip")
    public Result<String> rechargeYearVip(@RequestBody RechargeReq req) {
        if (req.getPhone() == null) {
            return Result.fail("参数为空，请检查参数");
        }
        //先查询用户数据

        User userInfo = userMapper.getUserInfo(req.getPhone());
        if (userInfo == null) {
            return Result.fail("用户不存在");
        }
        //先判断用户是否已经是会员

        User user = new User();
        user.setPhone(req.getPhone());
        user.setUpdatedAt(new Date());
        user.setDouJia(userInfo.getDouJia() + 300);
        user.setIsVip(2);
        userMapper.updateUserInfo(user);

        return Result.success("充值成功，您已经是尊贵的年度VIP用户");

    }

}
