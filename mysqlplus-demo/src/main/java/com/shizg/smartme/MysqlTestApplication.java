package com.shizg.smartme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.shizg.smartme.**.mapper")
//@ComponentScan(basePackages = "com.example.mysqltest.*")
@EnableScheduling
@EnableAsync
public class MysqlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlTestApplication.class, args);
    }

}
