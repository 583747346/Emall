package com.emall.emallcommon.web.entity.vo;

import com.emall.emallcommon.web.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class BaseVo<T extends BasePo> implements Serializable {
    private String id;
    private String createdBy;
    private Date createdTime;
}
