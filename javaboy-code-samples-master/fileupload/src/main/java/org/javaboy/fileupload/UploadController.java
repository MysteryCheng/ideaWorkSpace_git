package org.javaboy.fileupload;

import  com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
//    // Endpoint以杭州为例，其它Region请按实际情况填写。
//    String endPoint = "oss-cn-hangzhou.aliyuncs.com";
//    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//    String accessKeyId = "LTAI4GBW5JDy7cJyVbMAinue";
//    String accessKeySecret = "XbZjXm3BQjEjfHNQ4pwInrSBKDKXKk";
//    String bucketName = "edu-mystery";

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endPoint = "oss-cn-hangzhou.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId = "LTAI4GCJKAGibdfFeC6iRKrm";
    String accessKeySecret = "hcBFbOHIY3X45P1TammYqYt6h5C7fE";
    String bucketName = "tenas";
    @PostMapping("/upload")
    public Map<String,Object> fileupload(MultipartFile file, HttpServletRequest req) throws IOException {
        Map<String, Object> result = new HashMap<>();
        String uploadUrl = null;

        //判断oss实例是否存在：如果不存在则创建，如果存在则获取
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        if (!ossClient.doesBucketExist(bucketName)) {
            //创建bucket
            ossClient.createBucket(bucketName);
            //设置oss实例的访问权限：公共读
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        }

        //获取上传文件流
        InputStream inputStream = file.getInputStream();

        //构建日期路径：avatar/2019/02/26/文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String filePath = sdf.format(new Date());

        //文件名：uuid.扩展名
        String original = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString();
        String fileType = original.substring(original.lastIndexOf("."));
        String newName = fileName + fileType;
        String fileUrl = "oss.console.aliyun.com" + "/" + filePath + "/" + newName;

        //文件上传至阿里云
        ossClient.putObject(bucketName, fileUrl, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //获取url地址
        uploadUrl = "http://" + bucketName + "." + endPoint + "/" + fileUrl;
        System.out.println(uploadUrl);
        result.put("picUrl",uploadUrl);
        return result;
    }
}
