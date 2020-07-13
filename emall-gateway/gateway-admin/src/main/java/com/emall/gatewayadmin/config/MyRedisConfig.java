package com.emall.gatewayadmin.config;

import com.emall.emallweb.redis.RedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {
}