package com.emall.emallumsservice.controller;

import com.emall.emallcore.result.Result;
import com.emall.emallumsentity.entity.params.OssDeleteParam;
import com.emall.emallumsservice.oss.OssUploadPicture;
import com.emall.emallumsservice.tool.OssBucketEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/oss")
@Api(value = "OSS图片上传API", tags = "OSS图片上传API")
public class OssUploadPicsController {

    @Autowired
    private OssUploadPicture ossUploadPicture;

    @ApiOperation(value = "OSS图片上传", notes = "OSS图片上传")
    @PostMapping(value = "/uploadPics")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result uploadPics(@RequestParam MultipartFile file,@RequestParam String ossPath) {
        String pictures = ossUploadPicture.uploadPicToOss(file, OssBucketEnum.valueOf(ossPath));
        return Result.success(pictures);
    }

    @ApiOperation(value = "OSS图片删除", notes = "OSS图片删除")
    @PostMapping("/deletePics")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deletePics(@RequestBody OssDeleteParam ossDeleteParam) {
        return Result.success(ossUploadPicture.deletePicFromOss(ossDeleteParam.getPictureName(), OssBucketEnum.valueOf(ossDeleteParam.getOssPicturePath())));
    }

}
