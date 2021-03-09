package com.emall.emallumsentity.entity.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("OSS文件删除请求参数")
public class OssDeleteParam {

    @ApiModelProperty("文件路径")
    private String pictureName;

    @ApiModelProperty("oss路径")
    private String ossPicturePath;

}
