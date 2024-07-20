package com.langlang.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;

public class RedisLock {
    private Jedis jedis;
    private String lockKey;
    private String lockValue;
    private int lockTimeout;

    public RedisLock(Jedis jedis, String lockKey, int lockTimeout) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.lockTimeout = lockTimeout;
        this.lockValue = UUID.randomUUID().toString();
    }

    public boolean acquire() {
        SetParams params = new SetParams().nx().px(lockTimeout);
        while (true) {
            String result = jedis.set(lockKey, lockValue, params);
            if ("OK".equals(result)) {
                return true;
            }
            try {
                Thread.sleep(10); // 等待10毫秒后重试
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
    }

    public boolean release() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 " +
                "end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(lockValue));
        return "1".equals(result.toString());
    }
}
