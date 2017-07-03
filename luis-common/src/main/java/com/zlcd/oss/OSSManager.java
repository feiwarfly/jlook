package com.zlcd.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Date;

/**
 */
public class OSSManager extends OSSClient {


    private OSSManager(String endpoint,String accessKeyId,String accessKeySecret) {
        super(endpoint,accessKeyId,accessKeySecret);
    }

    private static volatile OSSManager instance;

    public static OSSManager getIstance() {
        if (instance == null) {
            synchronized (OSSManager.class) {
                OSSConfigure ossConfigure = OSSConfigure.getInstance();
                if (instance == null) {
                    instance = new OSSManager
                            (ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
                }
            }
        }
        return instance;
    }

    /**
     * 上传OSS服务器文件
     *
     * @param @param  ossConfigure
     * @param @param  file
     * @param @param  remotePath
     * @param @return
     * @param @throws Exception    设定文件
     * @return String    返回类型
     * @throws
     * @Title: uploadFile
     * @Description:
     */
    public static String uploadFile(File file, String remotePath) throws Exception {
        OSSConfigure ossConfigure = OSSConfigure.getInstance();
        if (ossConfigure == null) return null;
        InputStream fileContent = null;
        fileContent = new FileInputStream(file);

        OSSClient ossClient = new OSSClient
                (ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
        //String remoteFilePath = remotePath.substring(0, remotePath.length()).replaceAll("\\\\","/")+"/";
        String remoteFilePath = remotePath.substring(0, remotePath.length()).replaceAll("\\\\", "/");
        //创建上传Object的Metadata
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(fileContent.available());
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        objectMetadata.setContentType(contentType(file.getName().substring(file.getName().lastIndexOf(".") + 1)));
        objectMetadata.setContentDisposition("inline;filename=" + file.getName());
        //上传文件
        ossClient.putObject(ossConfigure.getBucketName(), remoteFilePath, fileContent, objectMetadata);
        return ossConfigure.getAccessUrl() + "/" + remoteFilePath;
    }


    public static String uploadFile(InputStream fileContent, String remotePath, String contentType, String fileName, OSSClient ossClient) throws Exception {
        OSSConfigure ossConfigure = OSSConfigure.getInstance();
        if (ossConfigure == null) return null;
        if (ossClient == null) {
            ossClient = new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
        }
        String remoteFilePath = remotePath.substring(0, remotePath.length()).replaceAll("\\\\", "/") + "/";
        //创建上传Object的Metadata
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(fileContent.available());
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        objectMetadata.setContentType(contentType);
        objectMetadata.setContentDisposition("inline;filename=" + fileName);
        //上传文件
        ossClient.putObject(ossConfigure.getBucketName(), remoteFilePath + fileName, fileContent, objectMetadata);
        //System.out.println(ossConfigure.getAccessUrl()+"/" +remoteFilePath + file.getName());
        return ossConfigure.getAccessUrl() + "/" + remoteFilePath + fileName;
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param @param ossConfigure
     * @param @param filePath    设定文件
     * @return void    返回类型
     * @throws
     * @Title: deleteFile
     * @Description:
     */
    public static void deleteFile(String filePath, OSSClient ossClient) {
        OSSConfigure ossConfigure = OSSConfigure.getInstance();
        if (ossConfigure != null) {
            if (ossClient == null) {
                ossClient = new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
            }
            ossClient.deleteObject(ossConfigure.getBucketName(), filePath);
        }

    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     * @Version1.0
     */
    public static String contentType(String FilenameExtension) {
        if (FilenameExtension.equals("BMP") || FilenameExtension.equals("bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equals("GIF") || FilenameExtension.equals("gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equals("JPEG") || FilenameExtension.equals("jpeg") ||
                FilenameExtension.equals("JPG") || FilenameExtension.equals("jpg") ||
                FilenameExtension.equals("PNG") || FilenameExtension.equals("png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equals("HTML") || FilenameExtension.equals("html")) {
            return "text/html";
        }
        if (FilenameExtension.equals("TXT") || FilenameExtension.equals("txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equals("VSD") || FilenameExtension.equals("vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equals("PPTX") || FilenameExtension.equals("pptx") ||
                FilenameExtension.equals("PPT") || FilenameExtension.equals("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equals("DOCX") || FilenameExtension.equals("docx") ||
                FilenameExtension.equals("DOC") || FilenameExtension.equals("doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equals("XML") || FilenameExtension.equals("xml")) {
            return "text/xml";
        }
        return "text/html";
    }

    /**
     * 生成12个小时的URL
     *
     * @param key
     * @param ossClient
     * @return
     */
    public static String getSignedUrl(String key, OSSClient ossClient) {
        OSSConfigure ossConfigure = OSSConfigure.getInstance();
        if (ossConfigure == null) return null;
        Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 12);
        if (ossClient == null) {
            ossClient = new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
        }
        URL url = ossClient.generatePresignedUrl(ossConfigure.getBucketName(), key, expiration);
        return url.toString();
    }

    /**
     * OSS 获取流
     *
     * @param key
     * @return
     */
    public static InputStream getInputStream(String key, OSSClient ossClient) {
        OSSConfigure ossConfigure = OSSConfigure.getInstance();
        if (ossConfigure == null) return null;
        if (ossClient == null) {
            ossClient = new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
        }
        OSSObject ossObject = ossClient.getObject(ossConfigure.getBucketName(), key);
        return ossObject.getObjectContent();
    }

    /**
     * 生成临时URL
     *
     * @param key
     * @param expiration
     * @param ossClient
     * @return
     */
    public static String getSignedUrl(String key, Date expiration, OSSClient ossClient) {
        // 生成URL
        OSSConfigure ossConfigure = OSSConfigure.getInstance();
        if (ossConfigure == null) {
            return null;
        }
        if (ossClient == null) {
            ossClient = new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
        }
        URL url = ossClient.generatePresignedUrl(ossConfigure.getBucketName(), key, expiration);
        return url.toString();
    }

    //https://help.aliyun.com/document_detail/oss/oss-img-guide/access/signature.html
    /*public  static String getSignedUrlWithWaterMarker(String key,String watermark) throws Exception{
        //String watermark = "105433094-482828-106062.jpg@20P";
        byte[] encodedBytes = Base64.encodeBase64(watermark.getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        watermark=new String(encodedBytes);

        String verb="GET";
        String contentMD5="";
        String contentType="";
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        String canonicalizedOSSHeaders="";
        String canonicalizedResource=key+"@watermark=1&object="+watermark+"&t=90&p=9&x=10&y=10";
        OSSConfigure ossConfigure = OSSConfigure.getInstance();
        if (ossConfigure==null) return null;
        encodedBytes = Base64.encodeBase64(EncryptUtil.HmacSHA1Encrypt(ossConfigure.getAccessKeySecret(),
        verb + "\n"
                + contentMD5 + "\n"
                + contentType + "\n"
                + expiration + "\n"
                + canonicalizedOSSHeaders
                + canonicalizedResource));
        String signature=new String(encodedBytes);

        return ossConfigure.getImageService()+"/" +key+"@watermark=1&object="+watermark+"&t=90&p=9&x=10&y=10"+
                "OSSAccessKeyId="+ossConfigure.getAccessKeyId()+"&Expires="+expiration+"&Signature="+signature;
    }*/

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###.0");
        System.out.println(df.format(new BigDecimal(123456.75)));
        System.out.println(df.format(new BigDecimal(123456.00)));
        //System.out.println(getSignedUrl("workorder_99000718121583_42757d1c-a1f8-4ddd-b50a-2068c9786a2f.mp4"));
    }
}