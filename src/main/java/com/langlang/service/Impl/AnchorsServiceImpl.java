package com.langlang.service.Impl;

import com.langlang.dao.AnchorsMapper;
import com.langlang.dao.UserMapper;
import com.langlang.domain.Anchors;
import com.langlang.response.AnchorsInfoRsp;
import com.langlang.response.AnchorsRsp;
import com.langlang.service.AnchorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnchorsServiceImpl implements AnchorsService {
    @Autowired
    private AnchorsMapper anchorsMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<AnchorsRsp> getAnchorsList(Integer phone) {
        List<AnchorsRsp> anchorsRspList = anchorsMapper.getAnchorList(phone);
        return anchorsRspList;
    }

    @Override
    public AnchorsInfoRsp getAnchorInfo(Integer phone) {
        return anchorsMapper.getAnchorInfo(phone);
    }
}