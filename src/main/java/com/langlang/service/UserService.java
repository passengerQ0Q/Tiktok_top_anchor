package com.langlang.service;



import com.langlang.domain.Admin;
import com.langlang.domain.Users;

import java.util.List;

/**
 * 用户登录接口
 */
public interface UserService {
   //获取主播列表
    public List<Users> getUsers();

    //登录
    public String login(Integer phone, String password);
    //注册
    public String regester(Users users);
    //修改
    public Integer updateUserInfo(Users users);

    //获取用户信息
    public Users getUserInfo(Integer phone);
}

