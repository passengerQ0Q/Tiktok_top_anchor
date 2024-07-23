package com.langlang.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.langlang.domain.Messages;
import com.langlang.service.MessagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {

    @Autowired
    private MessagesService messagesService;

    @KafkaListener(topics = "messages", groupId = "pushservice-system-web")
    public void consume(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Messages Obj = mapper.readValue(message, Messages.class);
            messagesService.insert(Obj);
            log.info("消费消息成功");
        } catch (Exception e) {
            log.error("消费消息失败", e);
            throw new RuntimeException("消费消息失败");
        }



    }
}
