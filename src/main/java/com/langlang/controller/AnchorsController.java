package com.langlang.controller;

import com.langlang.domain.Anchors;
import com.langlang.response.AnchorsInfoRsp;
import com.langlang.response.AnchorsRsp;
import com.langlang.service.AnchorsService;
import com.langlang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnchorsController {
    @Autowired
    private AnchorsService anchorsService;
//    @ApiOperation("获取主播列表")
    @RequestMapping(value = "/getAnchorList")
    public Result<List<AnchorsRsp>> getAnchorList(Integer phone){
        return Result.success(anchorsService.getAnchorsList(phone)) ;
    }
    @RequestMapping(value = "/getAnchorInfo")
    public Result<AnchorsInfoRsp> getAnchorInfo(@RequestParam("phone") Integer phone){
        return Result.success(anchorsService.getAnchorInfo(phone)) ;
    }

}
