package com.langlang.service;

import com.langlang.domain.Anchors;
import com.langlang.response.AnchorsInfoRsp;
import com.langlang.response.AnchorsRsp;

import java.util.List;

/**
 * 主播接口
 */
public interface AnchorsService {
    //查询主播列表
    public List<AnchorsRsp> getAnchorsList(Integer phone);
    public AnchorsInfoRsp getAnchorInfo(Integer phone);
    public List<AnchorsRsp> getAnchorTypeList(Integer anchorType);


}
