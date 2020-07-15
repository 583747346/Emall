package com.emall.emalldeskfronton;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.emall.emalldeskfronton.mapper")
@EnableMethodCache(basePackages = "com.emall")
@EnableCreateCacheAnnotation
public class EmallDeskfrontonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallDeskfrontonApplication.class, args);
    }

}
