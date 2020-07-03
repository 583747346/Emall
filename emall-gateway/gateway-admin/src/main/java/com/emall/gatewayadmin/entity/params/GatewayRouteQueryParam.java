package com.emall.gatewayadmin.entity.params;

import com.emall.emallcommon.web.entity.params.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteQueryParam extends BaseParam {
    private String uri;
    private Date createdTimeStart;
    private Date createdTimeEnd;
    private String description;

    public GatewayRouteQueryParam(String uri) {
        this.uri = uri;
    }
}
