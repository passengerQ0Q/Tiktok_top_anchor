package com.langlang.domain;

public class Admin {
    /**
    * 管理员账号
    */
    private Integer adminAccount;

    /**
    * 管理员密码
    */
    private String adminPassword;

    public Integer getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(Integer adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}