package com.offway.popgxb.three;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.offway.popgxb.util.DateUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OssCore {

    // Endpoint以杭州为例，其它Region请按实际情况填写
    private static final String endpoint = "oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。
    // 强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    private static final String accessKeyId = "LTAI4G5cXDvFyUfZHhoXj3gh";
    private static final String accessKeySecret = "henvqsfkijiT3emedhjQkyMpt0fR6T";
    // 创建OSSClient实例。
    private static OSS ossClient;

    static {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    // 创建存储空间
    public static void createBucket(String bname) {
        // 创建CreateBucketRequest对象
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bname);
        // 创建存储空间
        ossClient.createBucket(createBucketRequest);
    }

    // 列出存储空间
    public static List<Bucket> listBucket() {
        return ossClient.listBuckets();
    }

    // 上传字符串
    public static String sendStr(String bname, String objname, String msg) {
        ossClient.putObject(bname, objname, new ByteArrayInputStream(msg.getBytes()));
        // 返回访问路径
        return ossClient.generatePresignedUrl(bname, objname, DateUtil.comDate(Calendar.YEAR, 1)).toString();
    }

    // 上传字节
    public static String sendResource(String bname, String objname, byte[] data) {
        ossClient.putObject(bname, objname, new ByteArrayInputStream(data));
        return ossClient.generatePresignedUrl(bname, objname, DateUtil.comDate(Calendar.YEAR, 1)).toString();
    }

    // 上传文件
    public static String sendFile(String bname, File file) {
        ossClient.putObject(bname, file.getName(), file);
        return ossClient.generatePresignedUrl(bname, file.getName(), DateUtil.comDate(Calendar.YEAR, 1)).toString();
    }

    public static String createURL(String bname, String objname, int days) {
        //获取访问路径
        return ossClient.generatePresignedUrl(bname, objname, DateUtil.comDate(Calendar.DAY_OF_MONTH, days)).toString();
    }

    // 删除
    public static boolean delResource(String bname, String objname) {
        try {
            ossClient.deleteObject(bname, objname);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 列举文件
    public static List<String> listResource(String bname) {
        List<String> files = new ArrayList<>();
        ObjectListing listing = ossClient.listObjects(bname);
        for (OSSObjectSummary o : listing.getObjectSummaries()) {
            files.add(o.getKey());
        }
        return files;
    }

}
