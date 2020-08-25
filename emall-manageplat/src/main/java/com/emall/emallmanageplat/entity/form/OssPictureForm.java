package com.emall.emallmanageplat.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@ApiModel(value = "OSS图片上传表单")
public class OssPictureForm implements Serializable {

    @ApiModelProperty(value = "上传的文件")
    private MultipartFile file;
    @ApiModelProperty(value = "上传的路径")
    private String path;

}
