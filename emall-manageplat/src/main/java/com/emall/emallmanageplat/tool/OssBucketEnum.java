package com.emall.emallmanageplat.tool;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum OssBucketEnum {

    BRAND_LOGO("brand/logo/"),
    BRAND_BIGPIC("brand/bigPic/"),
    MENU_ICON("/menu/icon"),
    SKU_LOGO("/sku/logo");

    String bucket;

    OssBucketEnum(String bucket) {
        this.bucket = bucket;
    }
}
