package com.langlang.controller;


import com.langlang.domain.Users;
import com.langlang.service.UserService;
import com.langlang.utils.Result;
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
    public Result<String> login(@RequestBody Users users) {
        return Result.success(userService.login(users.getPhone(), users.getPassword()));
    }

    //注册
    @ApiOperation("注册")
    @RequestMapping(value = "/regester")
    public Result<String> regester(@RequestBody Users req) {
        return Result.success(userService.regester(req));
    }

    //修改用户信息

    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/updateUserInfo")
    public Result<String> updateUserInfo(@RequestBody Users req) {
        userService.updateUserInfo(req);
        return Result.success("更新成功");

    }
    //获取用户信息
    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/getUserInfo")
    public Result<Users> getUserInfo(@RequestParam Integer phone) {
        return Result.success(userService.getUserInfo(phone));
    }




}
