package com.emall.emallmemberservice.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.emall.emallweb.context.UserApplicationContext;
import com.emall.emallweb.entity.po.BasePo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * MP---自动填充字段
 * MP API文档有
 * https://mp.baomidou.com/guide/auto-fill-metainfo.html
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入操作，字段填充 ->");
        String username = getUsername();
        this.strictInsertFill(metaObject, "createdTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createdBy", String.class, username);
        this.strictInsertFill(metaObject, "updatedTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updatedBy", String.class, username);
//        this.fillStrategy(metaObject, "createdTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
        /* 上面选其一使用,下面的已过时(注意 strictInsertFill 有多个方法,详细查看源码) */
        //this.setFieldValByName("operator", "Jerry", metaObject);
        //this.setInsertFieldValByName("operator", "Jerry", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新操作，字段填充（updatedBy字段更新） ->");
        String username = getUsername();
        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updatedBy", String.class, username);
//        this.fillStrategy(metaObject, "updatedTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
        /* 上面选其一使用,下面的已过时(注意 strictUpdateFill 有多个方法,详细查看源码) */
        //this.setFieldValByName("operator", "Tom", metaObject);
        //this.setUpdateFieldValByName("operator", "Tom", metaObject);
    }

    /**
     * 获取当用户
     */
    private String getUsername() {
        return StringUtils.defaultIfEmpty(UserApplicationContext.getInstance().getUsername(), BasePo.DEFAULT_USERNAME);
    }
}
