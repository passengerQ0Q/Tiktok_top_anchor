package com.langlang.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息表
 */
@Data
public class User {
    /**
    * 用户ID
    */
    private Integer id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 电子邮件地址
    */
    private String email;

    /**
    * 密码
    */
    private String password;

    /**
    * 用户全名
    */
    private String fullName;

    /**
    * 出生日期
    */
    private Date birthDate;

    /**
    * 性别
    */
    private Object gender;

    /**
    * 地址
    */
    private String address;

    /**
    * 城市
    */
    private String city;

    /**
    * 国家
    */
    private String country;

    /**
    * 邮政编码
    */
    private String zipCode;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 更新时间
    */
    private Date updatedAt;
    /**
     * 电话号
     */

    private Integer phone;

    /**
     * 是否是主播
     */
    private Integer isAnchor;


    /**
     * 是否是主播
     */
    private Integer douJia;

    /**
     * 钻石数
     */
    private Integer diamond;
    /**
     * 0: 非会员、1：会员 、2 ：年费会员
     */
    private Integer isVip;




}