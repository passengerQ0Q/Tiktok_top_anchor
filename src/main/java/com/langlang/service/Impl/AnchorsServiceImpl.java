package com.langlang.service.Impl;

import com.langlang.dao.AnchorsMapper;
import com.langlang.dao.UserMapper;
import com.langlang.domain.Anchors;
import com.langlang.domain.User;
import com.langlang.response.AnchorsInfoRsp;
import com.langlang.response.AnchorsRsp;
import com.langlang.service.AnchorsService;
import com.langlang.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnchorsServiceImpl implements AnchorsService {
    @Autowired
    private AnchorsMapper anchorsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<AnchorsRsp> getAnchorsList(Integer phone) {
        //查询前100个主播的信息
        //先从缓存读取数据
        List<AnchorsRsp> anchorsRspList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
        }
        Object obj =  redisTemplate.opsForList().range("top100AnchorsList", 0, -1);
        anchorsRspList = (List<AnchorsRsp>)obj;


        if (anchorsRspList.size() < 100) {
            List<AnchorsRsp> anchorRspList = anchorsMapper.getAnchorList();
            anchorsRspList.addAll(anchorRspList);
        }

        Collections.sort(anchorsRspList, (o1, o2)-> o1.getUpdatedAt().compareTo(o2.getUpdatedAt()));
        //将数据转换成AnchorsRsp

        return anchorsRspList;
    }

    @Override
    public AnchorsInfoRsp getAnchorInfo(Integer phone) {
        return anchorsMapper.getAnchorInfo(phone);
    }
}