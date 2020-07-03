package com.emall.gatewayadmin.config;

import com.emall.emallcommon.web.redis.RedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {
}