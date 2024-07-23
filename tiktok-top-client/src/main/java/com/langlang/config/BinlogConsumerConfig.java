package com.langlang.config;


import com.langlang.utils.BinlogConsumer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinlogConsumerConfig {


    @Value("${binlog.mysql.host}")
    @Getter
    private String host;

    @Value("${binlog.mysql.port}")
    @Getter
    private int port;
    @Getter
    @Value("${binlog.mysql.username}")
    private String username;
    @Getter
    @Value("${binlog.mysql.password}")
    private String password;

    @Bean
    public BinlogConsumer binlogConsumer() {
        return new BinlogConsumer(this);
    }

}

