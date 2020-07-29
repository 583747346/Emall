package com.emall.emallmanageplat.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.emall.emallcore.exception.ImgUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class OssUploadPicture {

    @Value("${oss.endpoint}")
    private static String endpoint;
    @Value("${oss.accessKeyId}")
    private static String accessKeyId;
    @Value("${oss.accessKeySecret}")
    private static String accessKeySecret;
    @Value("${oss.bucketName}")
    private static String bucketName;

    private static OSSClient ossClient;

    public static OssUploadPicture getInstance() {
        return SingletonOssUploadPicture.instance;
    }

    public static class SingletonOssUploadPicture {
        private static final OssUploadPicture instance = new OssUploadPicture();
    }

    /**
     * 静态代码块，jvm加载时，加载OssClient
     */
    static {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 保存图片到OSS服务器
     *
     * @param request
     * @return
     * @throws ImgUploadException
     */
    public String uploadPicToOss(HttpServletRequest request, String section, String filetype) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile(filetype);
//        int type = FileFilterMap.getType(filetype);
//        Map<String, Object> map = ConfigManage.getConfig(type);
        String url = "";
        try {
            PutObjectResult putResult = ossClient.putObject(bucketName, "yanxuan/picture/" + section + "/" + multipartFile.getOriginalFilename(), new ByteArrayInputStream(multipartFile.getBytes()), new ObjectMetadata());
            url = getUrl("yanxuan/picture/" + section + "/" + multipartFile.getOriginalFilename());
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
