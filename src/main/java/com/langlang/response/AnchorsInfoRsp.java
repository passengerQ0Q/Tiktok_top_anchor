package com.langlang.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AnchorsInfoRsp {
    /**
     * 主播名称
     */
    private String username;
    /**
     * 主播性别
     */
    private String gender;
    /**
     * 电话号
     */
    private String phone;

    /**
     * 流量来源
     */
    private String trafficSource;

    /**
     * 观看人群
     */
    private String audienceDemographics;

    /**
     * 账号标签
     */
    private String accountTags;

    /**
     * 礼物收入
     */
    private BigDecimal giftIncome;

    /**
     * 广告收入
     */
    private BigDecimal adIncome;

    /**
     * 平均停留时长
     */
    private Integer averageStayDuration;

    /**
     * 粉丝量级
     */
    private Long followersCount;
}
