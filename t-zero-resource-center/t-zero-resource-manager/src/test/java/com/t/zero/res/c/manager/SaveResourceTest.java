package com.t.zero.res.c.manager;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

/**
 * @author davinzhang
 * @date 2022/02/03
 * @desc TODO
 */
//@SpringBootTest
public class SaveResourceTest {
    
    @Test
    public void test() {
       var path = Paths.get("/资源管理");
       
       System.out.println(path.getFileName().toString());
       System.out.println(path.getParent().toString());
       
    }
} 
