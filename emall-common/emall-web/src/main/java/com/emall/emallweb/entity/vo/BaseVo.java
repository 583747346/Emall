package com.emall.emallweb.entity.vo;

import com.emall.emallweb.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class BaseVo<T extends BasePo> implements Serializable {
    private Long id;
    private String createdBy;
    private Date createdTime;
}
