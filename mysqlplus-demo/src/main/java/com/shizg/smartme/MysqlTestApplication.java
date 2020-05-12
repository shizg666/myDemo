package com.shizg.smartme;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.shizg.smartme.**.mapper")
@ComponentScan(basePackages = "com.shizg.smartme.*")
@EnableScheduling
@EnableAsync
@Slf4j
public class MysqlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlTestApplication.class, args);
    }


}
