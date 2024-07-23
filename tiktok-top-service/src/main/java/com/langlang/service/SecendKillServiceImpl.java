package com.langlang.service;

import com.langlang.dao.SeckillOrderMapper;
import com.langlang.domain.SeckillOrder;
import com.langlang.utils.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class SecendKillServiceImpl implements SecendKillService {
    @Autowired
    private SeckillOrderMapper seckillOrderMapper;
    private Jedis jedis;
    @Override
    public List<SeckillOrder> queryOrderList() {
        //查询订单列表
        return null;
    }

    @Override
    public void killOrder(SeckillOrder req) {
        //操作订单
        //
    }

    private boolean createOrder(String userId, String productId) {
        String lockKey = "lock:order:" + productId;
        RedisLock lock = new RedisLock(jedis, lockKey, 10000);

        try {
            // 获取锁
            if (!lock.acquire()) {
                System.out.println("无法获取锁");
                return false;
            }

            // 检查库存
            String stockStr = jedis.get("stock:" + productId);
            if (stockStr == null || Integer.parseInt(stockStr) <= 0) {
                System.out.println("商品库存不足");
                return false;
            }

            // 扣减库存
            jedis.decr("stock:" + productId);

            // 创建订单逻辑
            // 假设有个订单数据库
            // String orderId = orderDb.createOrder(userId, productId);
            System.out.println("用户" + userId + "成功购买商品" + productId);
            return true;
        } finally {
            // 释放锁
            lock.release();
        }
    }

    @Override
    public SeckillOrder queryOrderDetail() {
        return null;
    }
}
