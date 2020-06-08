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


create table emall_brand
(
   id                   bigint not null auto_increment,
   name                 varchar(64) comment '名称',
   first_letter         varchar(8) comment '首字母',
   sort                 int comment '排序',
   factory_status       int(1) comment '是否为品牌制造商：0->不是；1->是',
   show_status          int(1) comment '是否显示',
   product_count        int comment '产品数量',
   product_comment_count int comment '产品评论数量',
   logo                 varchar(255) comment '品牌logo',
   big_pic              varchar(255) comment '专区大图',
   brand_story          text comment '品牌故事',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品品牌';

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
    promotion_type INT(1) COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购'
)

