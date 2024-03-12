package com.langlang.dao;


import com.langlang.domain.Admin;
import com.langlang.domain.User;
import com.langlang.domain.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    Admin selectByAccountAndPassword(Integer adminAccount);
    User selectByPhone(Integer Phone);

    Integer insertUser(User user);

    Integer updateUserPassword(User user);


    Integer updateUserInfo(User user);

    User getUserInfo(Integer Phone);
}