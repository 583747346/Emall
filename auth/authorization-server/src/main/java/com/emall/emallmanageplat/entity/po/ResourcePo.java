package com.emall.emallmanageplat.entity.po;

import com.emall.emallweb.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 资源消息接收对象
 */
@Data
@NoArgsConstructor
public class ResourcePo extends BasePo {

    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;

}
