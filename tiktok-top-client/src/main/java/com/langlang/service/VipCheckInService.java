package com.langlang.service;

import com.langlang.domain.VipCheckIn;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("vipCheckInService")
public interface VipCheckInService {
    @POST
    @Path("insert")
    public int insert(VipCheckIn vipCheckIn);
    @POST
    @Path("selectByPhone")
    public VipCheckIn selectByPhone(Integer phone);
    @POST
    @Path("updateByPhone")
    public int updateByPhone(VipCheckIn record);
}
