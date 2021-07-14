package com.luojbin.demo.spring.boot.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.format.DateTimeParseException;

@Slf4j
public class TtlRedisCacheManager extends RedisCacheManager {
    public TtlRedisCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
        super(cacheWriter, defaultCacheConfiguration);
    }

    @Override
    protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {
        String[] array = StringUtils.delimitedListToStringArray(name, "@");
        name = array[0];
        if (array.length > 1) {
            try {
                    Duration duration = Duration.parse(array[1]);
                    cacheConfig = cacheConfig.entryTtl(duration);
            } catch (DateTimeParseException e) {
                log.error("错误的 TTL 格式");
                throw e;
            }
        }
        return super.createRedisCache(name, cacheConfig);
    }
}
