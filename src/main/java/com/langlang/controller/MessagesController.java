package com.langlang.controller;

import com.langlang.domain.Messages;
import com.langlang.service.MessagesService;
import com.langlang.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MessagesController {
    @Autowired
    private MessagesService messagesSevice;

    /**
     * 删除消息
     * @param id
     * @param createdTime
     * @return
     */
    @RequestMapping("/messages/delete")
    public int deleteByPrimaryKey(Integer id, Date createdTime){
        return 0;
    }

    /**
     * 插入消息
     * @param record
     * @return
     */
    @RequestMapping("/messages/insert")
    public Result<Boolean> insert(@RequestBody Messages record) {
        if (record.getPhone() == null || StringUtils.isBlank(record.getTitle()) || StringUtils.isBlank(record.getCreatedTime())) {
            return Result.fail("参数不能为空");
        }
        return Result.success(messagesSevice.insert(record));
    }

    @RequestMapping("/messages/queryByVip")
    public Result<List<Messages>> queryByVip(@RequestBody Messages req) {
        if (req.getPhone() == null) {
            return Result.fail("电话号不能为空");
        }
        return Result.success(messagesSevice.qureyByVip(req));
    }


}
