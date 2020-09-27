CREATE TABLE `emall_full_promotion` (
  `id` bigint(16) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品编号',
  `full_price` decimal(10,2) DEFAULT NULL COMMENT '商品满价（需要满足的金额）',
  `reduce_price` decimal(10,2) DEFAULT NULL COMMENT '商品减价（满减金额）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='满减促销表';
