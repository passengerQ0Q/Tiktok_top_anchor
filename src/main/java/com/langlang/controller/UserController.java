package com.langlang.controller;


import com.langlang.domain.Users;
import com.langlang.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @RequestMapping(value = "/login")
    public String login(@RequestBody Users users) {
        return userService.login(users.getPhone(), users.getPassword());
    }

    //注册
    @ApiOperation("注册")
    @RequestMapping(value = "/regester")
    public String regester(@RequestBody Users req) {
        return userService.regester(req);
    }

    //修改用户信息

    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/updateUserInfo")
    public String updateUserInfo(@RequestBody Users req) {
        userService.updateUserInfo(req);
        return "更新成功";

    }
    //获取用户信息
    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/getUserInfo")
    public Users getUserInfo(@RequestParam Integer phone) {
        return userService.getUserInfo(phone);
    }


}
