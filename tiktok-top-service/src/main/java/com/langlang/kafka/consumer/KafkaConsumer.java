package com.langlang.kafka.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 卡夫卡消费者
 *
 * @author
 * @date
 */
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test", groupId = "pushservice-system-web")
    public void consume(String message) {

        // 调用查询消息列表接口
        //
        System.out.println("Received message: " + message);
    }
}