CREATE TABLE `emall_product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级分类的编号：0表示一级分类',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `level` int(1) DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `product_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `product_unit` varchar(64) DEFAULT NULL COMMENT '商品单位',
  `nav_status` int(1) DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `description` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类';


CREATE TABLE emall_brand (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) COMMENT '名称',
    first_letter VARCHAR(8) COMMENT '首字母',
    sort INT COMMENT '排序',
    factory_status INT(1) COMMENT '是否为品牌制造商：0->不是；1->是',
    show_status INT(1) COMMENT '是否显示',
    product_count INT COMMENT '产品数量',
    product_comment_count INT COMMENT '产品评论数量',
    logo VARCHAR(255) COMMENT '品牌logo',
    big_pic VARCHAR(255) COMMENT '专区大图',
    brand_story TEXT COMMENT '品牌故事',
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='商品品牌';


CREATE TABLE emall_product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) COMMENT '商品名称',
    picture VARCHAR(255) COMMENT '商品图片',
    product_sn VARCHAR(64) NOT NULL COMMENT '商品货号',
    sort INT COMMENT '排序',
    price DECIMAL(10 , 2 ) COMMENT '价格',
    promotion_price DECIMAL(10 , 2 ) COMMENT '促销价格',
    description TEXT COMMENT '商品描述',
    original_price DECIMAL(10 , 2 ) COMMENT '市场价',
    sub_title VARCHAR(255) COMMENT '副标题',
    unit VARCHAR(16) COMMENT '单位',
    weight DECIMAL(10 , 2 ) COMMENT '商品重量，默认为克',
    service_ids VARCHAR(64) COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
    note VARCHAR(255) COMMENT '备注',
    album_pics VARCHAR(255) COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
    detail_title VARCHAR(255) COMMENT '详情标题',
    detail_desc TEXT COMMENT '详情描述',
    delete_status INT(1) COMMENT '删除状态：0->未删除；1->已删除',
    publish_status INT(1) COMMENT '上架状态：0->下架；1->上架',
    new_status INT(1) COMMENT '新品状态:0->不是新品；1->新品',
    recommand_status INT(1) COMMENT '推荐状态；0->不推荐；1->推荐',
    purchase_point INT COMMENT '购买赠送积分值',
    purchase_growth INT COMMENT '购买赠送成长值',
    promotion_limit INT COMMENT '促销限购数量',
    promotion_startdate DATETIME COMMENT '促销开始时间',
    promotion_entdate DATETIME COMMENT '促销结束时间',
    promotion_type INT(1) COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';


CREATE TABLE emall_product_sku (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT COMMENT '商品id',
    sku_code VARCHAR(64) NOT NULL COMMENT 'sku编码',
    price DECIMAL(10 , 2 ) COMMENT '价格',
    stock INT DEFAULT 0 COMMENT '库存',
    low_stock INT COMMENT '预警库存',
    picture VARCHAR(255) COMMENT '展示图片',
    sale INT COMMENT '销量',
    promotion_price DECIMAL(10 , 2 ) COMMENT 'sku促销价格',
    lock_stock INT DEFAULT 0 COMMENT '锁定库存',
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='商品sku';

CREATE TABLE emall_product_attribute (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_attribute_category_id BIGINT COMMENT '商品属性分类id',
    name VARCHAR(64) COMMENT '名称',
    select_type INT(1) COMMENT '属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；',
    input_type INT(1) COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
    input_list VARCHAR(255) COMMENT '可选值列表，以逗号隔开',
    sort INT COMMENT '排序字段：最高的可以单独上传图片',
    filter_type INT(1) COMMENT '分类筛选样式：1->普通；1->颜色',
    search_type INT(1) COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
    related_status INT(1) COMMENT '相同属性产品是否关联；0->不关联；1->关联',
    hand_add_status INT(1) COMMENT '是否支持手动新增；0->不支持；1->支持',
    type INT(1) COMMENT '属性的类型；0->规格；1->参数',
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='商品属性表';


CREATE TABLE emall_product_attribute_value (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT COMMENT '商品id',
    product_attribute_id BIGINT COMMENT '商品属性id',
    value VARCHAR(64) COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
    price DECIMAL(10 , 2 ) COMMENT '价格',
	stock INT DEFAULT 0 COMMENT '库存',
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='商品规格属性';


CREATE TABLE emall_product_attribute_relation (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_attribute_value_id BIGINT COMMENT '商品属性值id',
    product_attribute_id BIGINT COMMENT '商品属性id',
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='商品属性值-属性关系表';


