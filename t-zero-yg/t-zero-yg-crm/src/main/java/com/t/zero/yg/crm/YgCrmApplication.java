package com.t.zero.yg.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.t.zero.common.jasypt.TZeroTextEncryptor;

@MapperScans({@MapperScan("com.t.zero.yg.crm.bu.dao")})
@SpringBootApplication
public class YgCrmApplication {
	
	public static void main(String[] args) {
        TZeroTextEncryptor.updateSystemProperties();
        SpringApplication.run(YgCrmApplication.class, args);
    }
}
