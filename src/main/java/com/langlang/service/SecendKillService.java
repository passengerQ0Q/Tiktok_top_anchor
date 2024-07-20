package com.langlang.service;

import com.langlang.domain.SeckillOrder;

import java.util.List;

public interface SecendKillService {

    List<SeckillOrder> queryOrderList();
    void killOrder(SeckillOrder req);
    SeckillOrder queryOrderDetail();

}
