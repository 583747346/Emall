package com.emall.emallmanageplat;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.emall.emallmanageplat.mapper")
@EnableMethodCache(basePackages = "com.emall")
@EnableCreateCacheAnnotation
public class EmallManageplatApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallManageplatApplication.class, args);
    }

}
