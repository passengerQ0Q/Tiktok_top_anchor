package com.langlang.domain;

import java.math.BigDecimal;

public class Anchors {
    /**
    * 直播间ID
    */
    private Integer id;

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

    /**
    * 主播电话号
    */
    private Integer phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrafficSource() {
        return trafficSource;
    }

    public void setTrafficSource(String trafficSource) {
        this.trafficSource = trafficSource;
    }

    public String getAudienceDemographics() {
        return audienceDemographics;
    }

    public void setAudienceDemographics(String audienceDemographics) {
        this.audienceDemographics = audienceDemographics;
    }

    public String getAccountTags() {
        return accountTags;
    }

    public void setAccountTags(String accountTags) {
        this.accountTags = accountTags;
    }

    public BigDecimal getGiftIncome() {
        return giftIncome;
    }

    public void setGiftIncome(BigDecimal giftIncome) {
        this.giftIncome = giftIncome;
    }

    public BigDecimal getAdIncome() {
        return adIncome;
    }

    public void setAdIncome(BigDecimal adIncome) {
        this.adIncome = adIncome;
    }

    public Integer getAverageStayDuration() {
        return averageStayDuration;
    }

    public void setAverageStayDuration(Integer averageStayDuration) {
        this.averageStayDuration = averageStayDuration;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Long followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}