package com.langlang.service.Impl;


import com.langlang.domain.Admin;
import com.langlang.domain.User;
import com.langlang.domain.Users;
import com.langlang.dao.UserMapper;

import com.langlang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> getUsers() {
        return null;
    }


    @Override
    public String login(Integer phone, String password) {
        User user = userMapper.selectByPhone(phone);
        if (user == null) {
            return "用户不存在";
        }
        if (user.getPassword().equals(password)) {
            return "登录成功";
        }
        return "账号或者密码不正确";

    }

    @Override
    public String regester(User user) {

        if (userMapper.selectByPhone(user.getPhone()) != null) {
            return "手机号已被注册";
        }

        userMapper.insertUser(user);
        return "注册成功";
    }

    @Override
    public Integer updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);

    }

    /**
     * 登录后获取用户信息
     * @param phone
     * @return
     */
    @Override
    public User getUserInfo(Integer phone) {
        return userMapper.getUserInfo(phone);
    }


}
