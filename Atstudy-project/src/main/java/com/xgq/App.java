package com.xgq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


/** 
 * ClassName:App
 * Package: com.xgq
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 19:16
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.xgq.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);

        
    }
}
