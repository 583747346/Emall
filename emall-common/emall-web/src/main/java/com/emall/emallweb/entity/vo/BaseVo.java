package com.emall.emallweb.entity.vo;

import com.emall.emallweb.entity.po.BasePo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class BaseVo<T extends BasePo> implements Serializable {
    private Long id;
    @ApiModelProperty("创建人")
    private String createdBy;
    @ApiModelProperty("更新人")
    private String updatedBy;
    @ApiModelProperty("更新时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;
    @ApiModelProperty("创建时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
}
