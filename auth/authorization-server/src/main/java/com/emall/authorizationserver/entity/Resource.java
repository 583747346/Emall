package com.emall.authorizationserver.entity;

import com.emall.emallweb.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Resource extends BasePo {

    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;

}
