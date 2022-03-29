package com.t.zero.res.c.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.t.zero.common.jasypt.TZeroTextEncryptor;

import io.micrometer.core.instrument.MeterRegistry;

/**
 * @author davinzhang
 * @date 2022/02/01
 * @desc TODO
 */

//@EnableDiscoveryClient
@MapperScans({@MapperScan("com.t.zero.res.c.manager.bu.dao")})
//@EnableOpenApi
@SpringBootApplication
public class ResouceManagerApplication {

    public static void main(String[] args) {
        TZeroTextEncryptor.updateSystemProperties();
        SpringApplication.run(ResouceManagerApplication.class, args);
    }
    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return registry -> registry.config().commonTags("application", applicationName);
    }
}
