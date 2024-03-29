package com.langlang.dao;

import com.langlang.domain.Anchors;
import com.langlang.response.AnchorsInfoRsp;
import com.langlang.response.AnchorsRsp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnchorsMapper {

    List<AnchorsRsp> getAnchorList();

    AnchorsInfoRsp getAnchorInfo(Integer phone);

    List<AnchorsRsp> getAnchorTypeList(Integer anchorType);
}