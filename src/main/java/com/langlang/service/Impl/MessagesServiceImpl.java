package com.langlang.service.Impl;

import com.langlang.dao.MessagesMapper;
import com.langlang.domain.Messages;
import com.langlang.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesMapper messagesMapper;
    @Override
    public int deleteByPrimaryKey(Integer id, Date createdTime) {
        messagesMapper.deleteByPrimaryKey(id,createdTime);
        return 0;
    }

    @Override
    public boolean insert(Messages record) {
         messagesMapper.insert(record);
        return true;
    }
    @Override
    public List<Messages> qureyByVip(Messages req){
        return messagesMapper.queryByVip(req);
    }
    @Override
    public Messages qureyByVipOne(Messages req){
        return messagesMapper.queryByVipOne(req);
    }
}
