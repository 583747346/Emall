package com.emall.emallmanageplat.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.emall.emallcore.exception.ImgUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
    public String uploadPicToOss(MultipartFile file,String section) {

        String url = "";
        try {
            PutObjectResult putResult = ossClient.putObject(bucketName, section + file.getOriginalFilename(), new ByteArrayInputStream(file.getBytes()), new ObjectMetadata());
            url = getUrl(section + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ImgUploadException e) {
            e.printStackTrace();
        }
        return url;
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
