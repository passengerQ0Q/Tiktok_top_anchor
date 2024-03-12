package com.langlang.service;



import com.langlang.domain.Admin;
import com.langlang.domain.User;
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
    public String regester(User user);
    //修改
    public Integer updateUserInfo(User user);

    //获取用户信息
    public User getUserInfo(Integer phone);
}

