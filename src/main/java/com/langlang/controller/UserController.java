package com.langlang.controller;


import com.langlang.domain.User;
import com.langlang.domain.Users;
import com.langlang.service.UserService;
import com.langlang.utils.Result;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    //    @ApiOperation("登录")
    @RequestMapping(value = "/login")
    public Result<String> login(@RequestBody User user) {
        return Result.success(userService.login(user.getPhone(), user.getPassword()));
    }

    //注册
//    @ApiOperation("注册")
    @RequestMapping(value = "/regester")
    public Result<String> regester(@RequestBody User req) {
        return Result.success(userService.regester(req));
    }

    //修改用户信息

    //    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/updateUserInfo")
    public Result<String> updateUserInfo(@RequestBody User req) {
        userService.updateUserInfo(req);
        return Result.success("更新成功");

    }

    //获取用户信息
//    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/getUserInfo")
    public Result<User> getUserInfo(@RequestParam Integer phone) {
        return Result.success(userService.getUserInfo(phone));
    }

    @RequestMapping(value = "/test")
    public String test() {
        redisTemplate.opsForValue().set("test", "123");
        return redisTemplate.opsForValue().get("test").toString();
    }


}
