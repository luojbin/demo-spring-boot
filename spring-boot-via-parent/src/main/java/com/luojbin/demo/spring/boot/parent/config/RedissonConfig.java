package com.luojbin.demo.spring.boot.parent.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redisson() {
        Config config = new Config();
        config.setCodec(new StringCodec());
        config.useSingleServer()
                .setAddress("redis://192.168.0.101:6379")
                .setDatabase(1);
        return Redisson.create(config);
    }
}
