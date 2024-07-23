package com.langlang.service;


import com.langlang.domain.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 用户登录接口
 */
@Path("userService")
public interface UserService {

    @Path("login")
    @POST
    //登录
    public String login(Integer phone, String password);
    @Path("regester")
    @POST
    //注册
    public String regester(User user);
    @Path("updateUserInfo")
    @POST
    //修改
    public Integer updateUserInfo(User user);
    @Path("getUserInfo")
    @POST
    //获取用户信息
    public User getUserInfo(Integer phone);
}

