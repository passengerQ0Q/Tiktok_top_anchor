package com.langlang.utils;


import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.EventType;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;
import com.langlang.config.BinlogConsumerConfig;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Slf4j
public class BinlogConsumer implements ApplicationRunner {


    @Autowired
    private BinlogConsumerConfig config;

    private BinaryLogClient client;

    public BinlogConsumer(BinlogConsumerConfig config) {
        this.config = config;
    }

    @PostConstruct
    public void startListening() {
        client = new BinaryLogClient(config.getHost(), config.getPort(), config.getUsername(), config.getPassword());
        registerEventListener(client);
        try {
            client.connect();
        } catch (Exception e) {
            // Handle exception, log error, etc.
            e.printStackTrace();
        }
    }

    private void registerEventListener(BinaryLogClient client) {
        client.registerEventListener(event -> {
            EventType eventType = event.getHeader().getEventType();
            if (eventType == EventType.WRITE_ROWS) {
                WriteRowsEventData writeEventData = (WriteRowsEventData) event.getData();
                System.out.println("Push to downstream Kafka");
                // 这里调用RPC接口 实现真正的业务逻辑
            }

        });
    }

    @PreDestroy
    public void stopListening() {
        if (client != null) {
            try {
                client.disconnect();
            }catch (IOException e) {
                log.error("Error disconnecting from MySQL binlog", e);
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void run(ApplicationArguments args) {

    }
}
