package com.t.zero.cust.app.co.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "t.zero.file")
public class MultiFileUploadConfig {

    private List<String> supportBusinessTypes;

    @Value("${max.upload.size: 1024}")
    private int maxUploadSize;

    @Value("${save.path:./upload-files}")
    private String savePath;

    @Value("${max.in.memory.size: 40960}")
    private int maxInMemorySize;

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(maxInMemorySize);
        resolver.setMaxUploadSize(maxUploadSize * 1024 * 1024);
        return resolver;
    }
}
