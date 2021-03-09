DROP TABLE IF EXISTS `emall_advertise`;
CREATE TABLE `emall_advertise` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` VARCHAR(100) DEFAULT NULL COMMENT '描述',
    `position` INT(1) DEFAULT NULL COMMENT '轮播位置：0->PC首页轮播；1->app首页轮播',
    `picture` VARCHAR(500) DEFAULT NULL COMMENT '图片地址',
    `start_time` DATETIME DEFAULT NULL COMMENT '开始时间',
    `end_time` DATETIME DEFAULT NULL COMMENT '结束时间',
    `status` INT(1) DEFAULT NULL COMMENT '上下线状态：0->下线；1->上线',
    `pageview` INT(11) DEFAULT NULL COMMENT '浏览量',
    `order_count` INT(11) DEFAULT NULL COMMENT '下单数',
    `direct_url` VARCHAR(500) DEFAULT NULL COMMENT '链接地址',
    `note` VARCHAR(500) DEFAULT NULL COMMENT '备注',
    `sort` INT(11) DEFAULT '0' COMMENT '排序',
    `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_by` VARCHAR(20) NOT NULL COMMENT '创建人',
    `updated_by` VARCHAR(20) NOT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=12 DEFAULT CHARSET=UTF8 COMMENT='首页轮播广告表';