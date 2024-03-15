package com.langlang.controller;


import jakarta.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/test")
    public String testKafka() {
        String message = "hello";
        kafkaTemplate.send("test", message);
        return message;
    }
}