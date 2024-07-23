package com.langlang.service;

import com.langlang.domain.SeckillOrder;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("seckillService")
public interface SecendKillService {

    @POST
    @Path("queryOrderList")
    List<SeckillOrder> queryOrderList();
    @POST
    @Path("killOrder")
    void killOrder(SeckillOrder req);
    @POST
    @Path("queryOrderDetail")
    SeckillOrder queryOrderDetail();

}
