package com.t.zero.common.jasypt;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;

public class TZeroTextEncryptor {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        textEncryptor.setPassword("123456");
        // 要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("123456");
        System.out.println("username:" + username);
        System.out.println("password:" + password);

        updateSystemProperties();

    }

    public static void updateSystemProperties() {
        var jasyptEncryptorPassword = System.getenv("JASYPT_ENCRYPTOR_PASSWORD");
        if (StringUtils.isNotBlank(jasyptEncryptorPassword)) {
            System.setProperty("jasypt.encryptor.password", jasyptEncryptorPassword);
        }
        System.out.println(System.getProperty("jasypt.encryptor.password"));
    }
}
