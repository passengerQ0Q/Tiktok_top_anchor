package com.langlang.service;

import com.langlang.domain.Messages;
import com.langlang.request.MessageReq;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MessagesService {
    public int deleteByPrimaryKey(Integer id, Date createdTime);

    public boolean insert(Messages record);
    public List<Messages> qureyByVip(Messages req);
    public Messages qureyByVipOne(Messages req);

}
