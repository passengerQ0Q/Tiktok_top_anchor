package com.langlang.request;

import lombok.Data;

@Data
public class RechargeReq {
    //电话号
    private Integer phone;
    //密码
    private String password;
    //金额
    private Integer money;
}
