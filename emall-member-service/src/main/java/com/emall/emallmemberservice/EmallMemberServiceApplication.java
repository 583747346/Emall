package com.emall.emallmemberservice;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.emall")
@MapperScan(basePackages = "com.emall.emallmemberservice.mapper")
@EnableMethodCache(basePackages = "com.emall")
@EnableCreateCacheAnnotation
public class EmallMemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallMemberServiceApplication.class, args);
    }

}
