package com.langlang.service;

import com.langlang.response.AnchorsInfoRsp;
import com.langlang.response.AnchorsRsp;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * 主播接口
 */
@Path("anchorsService")
public interface AnchorsService {
    @Path("getAnchorsList")
    @POST
    //查询主播列表
    public List<AnchorsRsp> getAnchorsList(Integer phone);
    @Path("getAnchorInfo")
    @POST
    public AnchorsInfoRsp getAnchorInfo(Integer phone);
    @Path("getAnchorTypeList")
    @POST
    public List<AnchorsRsp> getAnchorTypeList(Integer anchorType);


}
