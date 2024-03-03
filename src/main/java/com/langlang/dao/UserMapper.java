package com.langlang.dao;


import com.langlang.domain.Admin;
import com.langlang.domain.User;
import com.langlang.domain.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    Admin selectByAccountAndPassword(Integer adminAccount);
    Users selectByPhone(Integer Phone);

    Integer insertUser(Users user);

    Integer updateUserPassword(Users user);


    Integer updateUserInfo(Users users);

    Users getUserInfo(Integer Phone);
}