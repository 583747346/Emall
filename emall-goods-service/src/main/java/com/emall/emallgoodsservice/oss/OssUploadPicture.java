package com.emall.emallgoodsservice.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.emall.emallcore.exception.ImgUploadException;
import com.emall.emallcore.exception.OssOperationException;
import com.emall.emallgoodsservice.tool.OssBucketEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Date;

@Component
public class OssUploadPicture {

    @Value("${oss.bucketName}")
    private String bucketName;

    @Autowired
    private OSSClient ossClient;

    /**
     * 保存图片到OSS服务器
     *
     * @return
     * @throws ImgUploadException
     */
    public String uploadPicToOss(MultipartFile file, OssBucketEnum bucketEnum) {

        String url = "";
        try {
            PutObjectResult putResult = ossClient.putObject(bucketName, bucketEnum.getBucket() + file.getOriginalFilename(), new ByteArrayInputStream(file.getBytes()), new ObjectMetadata());
            url = getUrl(bucketEnum.getBucket() + file.getOriginalFilename());
        } catch (Exception e) {
            throw new OssOperationException("表单添加OSS上传图片异常");
        }
        return url;
    }

    /**
     * 删除OSS里面对应图片和文件
     *
     *
     * @param pictureName
     * @param bucketEnum
     * @return
     */
    public boolean deletePicFromOss(String pictureName, OssBucketEnum bucketEnum) {
        try {
            ossClient.deleteObject(bucketName, bucketEnum.getBucket() + pictureName);
        } catch (Exception e) {
            throw new OssOperationException("表单取消OSS删除图片异常");
        }
        return true;
    }

    /**
     * 获取图片在oss的外网地址, url有效期100年
     *
     * @param key
     * @return
     */
    public String getUrl(String key) throws ImgUploadException {
        // 设置URL过期时间为10年  3600l* 1000*24*365*100
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url == null) {
            throw new ImgUploadException("返回图片路径有误");
        }
        return url.toString();
    }

}
