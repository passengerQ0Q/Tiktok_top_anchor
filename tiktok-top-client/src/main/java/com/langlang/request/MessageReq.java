package com.langlang.request;

import lombok.Data;

import java.util.Date;

@Data
public class MessageReq {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 消息创建时间
     */
    private String createdTime;

    /**
     * 标题

     */
    private String title;

    /**
     * 消息内容
     */
    private String messageContent;

    /**
     * 电话号
     */
    private Integer phone;

}
