package com.emall.emallgoodsservice;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//添加scanBasePackages主要是因为全局异常在其他工程，这里要扫描包才能生效
@SpringBootApplication(scanBasePackages = "com.emall")
@MapperScan(basePackages = "com.emall.emallgoodsservice.mapper")
@EnableMethodCache(basePackages = "com.emall")
@EnableCreateCacheAnnotation
public class EmallGoodsServiceApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(EmallGoodsServiceApplication.class, args);
    }

}
