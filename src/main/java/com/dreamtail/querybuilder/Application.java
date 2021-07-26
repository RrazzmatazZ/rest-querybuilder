package com.dreamtail.querybuilder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author xdq
 * @version 1.0
 * @className Application
 * @description TODO
 * @date 2021/7/26 16:29
 */
@SpringBootApplication
@MapperScan("com.dreamtail.querybuilder.examples")
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
