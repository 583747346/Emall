DROP TABLE IF EXISTS `emall_product_comment`;
CREATE TABLE emall_product_comment (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT COMMENT '商品id',
    member_nick_name VARCHAR(255) COMMENT '会员昵称',
    product_name VARCHAR(255) COMMENT '商品名称',
    star INT(3) COMMENT '评价星数：0->5',
    member_ip VARCHAR(64) COMMENT '评价的ip',
    show_status INT(1) COMMENT '是否显示',
    product_attribute VARCHAR(255) COMMENT '购买时的商品属性',
    collect_couont INT COMMENT '收藏数',
    read_count INT COMMENT '浏览数',
    content TEXT COMMENT '内容',
    pics VARCHAR(1000) COMMENT '上传图片地址，以逗号隔开',
    member_icon VARCHAR(255) COMMENT '评论用户头像',
    replay_count INT COMMENT '回复数',
    created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    created_by VARCHAR(20) NOT NULL COMMENT '创建人',
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='商品评论表';


CREATE TABLE emall_product_comment_replay (
    id BIGINT NOT NULL AUTO_INCREMENT,
    comment_id BIGINT COMMENT '评论id',
    member_nick_name VARCHAR(255) COMMENT '会员昵称',
    member_icon VARCHAR(255) COMMENT '会员头像',
    content VARCHAR(1000) COMMENT '内容',
    type INT(1) COMMENT '评论人员类型；0->会员；1->管理员',
    created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    created_by VARCHAR(20) NOT NULL COMMENT '创建人',
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='商品评论回复表';