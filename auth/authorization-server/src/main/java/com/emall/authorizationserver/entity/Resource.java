package com.emall.authorizationserver.entity;

import com.emall.emallcommon.web.entity.BasePo;
import lombok.Data;

@Data
public class Resource extends BasePo {

    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;

}
