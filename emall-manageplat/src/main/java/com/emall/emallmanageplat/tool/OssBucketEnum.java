package com.emall.emallmanageplat.tool;

import lombok.Getter;

@Getter
public enum OssBucketEnum {

    BRAND_LOGO("/brand/logo/"),
    BRAND_BIGPIC("/brand/bigPic/"),
    MENU_ICON("/menu/icon/"),
    GOODS("/goods/"),
    GOODS_SKU("goods/sku/");

    String bucket;

    OssBucketEnum(String bucket) {
        this.bucket = bucket;
    }
}
