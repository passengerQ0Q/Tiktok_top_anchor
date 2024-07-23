package com.langlang.service;


import com.langlang.domain.Messages;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Date;
import java.util.List;
@Path("messagesService")
public interface MessagesService {
    @Path("deleteByPrimaryKey")
    @POST
    public int deleteByPrimaryKey(Integer id, Date createdTime);
    @POST
    @Path("insert")
    public boolean insert(Messages record);
    @POST
    @Path("qureyByVip")
    public List<Messages> qureyByVip(Messages req);
    @POST
    @Path("qureyByVipOne")
    public Messages qureyByVipOne(Messages req);

}
