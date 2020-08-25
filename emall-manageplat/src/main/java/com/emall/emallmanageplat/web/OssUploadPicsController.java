package com.emall.emallmanageplat.web;

import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.OssPictureForm;
import com.emall.emallmanageplat.oss.OssUploadPicture;
import com.emall.emallmanageplat.tool.OssBucketEnum;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oss")
public class OssUploadPicsController {

    @Autowired
    private OssUploadPicture ossUploadPicture;

    @ApiOperation(value = "OSS图片上传", notes = "OSS图片上传")
    @PostMapping(value = "/uploadPics")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result uploadPics(@RequestBody OssPictureForm ossPictureForm) {
        String pictures = ossUploadPicture.uploadPicToOss(ossPictureForm.getFile(), OssBucketEnum.valueOf(ossPictureForm.getPath()));
        return Result.success(pictures);
    }

}
