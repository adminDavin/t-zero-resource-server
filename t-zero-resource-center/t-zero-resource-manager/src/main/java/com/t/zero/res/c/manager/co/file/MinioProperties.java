package com.t.zero.res.c.manager.co.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:minio.yml")
public class MinioProperties {

    /**
     * MINIO 服务地址 http://ip:port
     */
    @Value("${url}")
    private String url;
    /**
     * 用户名
     */
    @Value("${access-key}")
    private String accessKey;
    /**
     * 密码
     */
    @Value("${secret-key}")
    private String secretKey;
    /**
     * 桶名称
     */
    @Value("${bucket-name}")
    private String bucketName;

}
