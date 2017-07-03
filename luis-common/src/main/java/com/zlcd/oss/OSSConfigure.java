package com.zlcd.oss;

import java.io.IOException;
import java.util.Properties;

public class OSSConfigure {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String accessUrl;


    public static OSSConfigure getInstance(){
        OSSConfigure configure=null;
        try {
            configure = new OSSConfigure();
            //return configure;
        }catch (IOException e){

        }catch (NullPointerException e){

        }
        return configure;
    }

    /**
     *
     * @throws IOException
     */
    private OSSConfigure() throws IOException,NullPointerException {

        String storageConfName = "application.properties";
        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader()
                .getResourceAsStream(storageConfName));
        endpoint = prop.getProperty("endpoint").trim();
        accessKeyId = prop.getProperty("accessKeyId").trim();
        accessKeySecret = prop.getProperty("accessKeySecret").trim();
        bucketName = prop.getProperty("bucketName").trim();
        //accessUrl = prop.getProperty("accessUrl").trim();
        this.accessUrl="http://"+this.bucketName+"."+this.endpoint;

    }

    private OSSConfigure(String endpoint, String accessKeyId,
                        String accessKeySecret, String bucketName) {

        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
        this.accessUrl="http://"+this.bucketName+"."+this.endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

}
