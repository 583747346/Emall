DROP TABLE IF EXISTS `emall_car`;
CREATE TABLE emall_car (
    `id` VARCHAR(11) NOT NULL COMMENT '购物车id',
    `product_id` BIGINT(20) DEFAULT NULL COMMENT '商品id',
    `sku_id` BIGINT(20) DEFAULT NULL COMMENT '商品sku-id',
    `member_id` BIGINT(20) DEFAULT NULL COMMENT '会员id',
    `quantity` INT(11) DEFAULT NULL COMMENT '购买数量',
    `price` DECIMAL(10 , 2 ) DEFAULT NULL COMMENT '添加到购物车的价格',
    `product_pic` VARCHAR(1000) DEFAULT NULL COMMENT '商品主图',
    `product_name` VARCHAR(500) DEFAULT NULL COMMENT '商品名称',
    `product_sub_title` VARCHAR(500) DEFAULT NULL COMMENT '商品副标题',
    `product_sku_code` VARCHAR(200) DEFAULT NULL COMMENT '商品sku条码',
    `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
    `delete_status` INT(1) DEFAULT ''0'' COMMENT '是否删除',
    `product_category_id` BIGINT(20) DEFAULT NULL COMMENT '商品分类',
    `product_brand` VARCHAR(200) DEFAULT NULL COMMENT '商品品牌',
    `product_no` VARCHAR(200) DEFAULT NULL COMMENT '商品货号',
    `specification` VARCHAR(500) DEFAULT NULL COMMENT '商品规格属性',
    `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by` VARCHAR(20) NOT NULL COMMENT '创建人',
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=22 DEFAULT CHARSET=UTF8 COMMENT=''购物车信息'';