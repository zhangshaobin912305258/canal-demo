package com.zhang.canaldemo;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCanalClient
public class CanalDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalDemoApplication.class, args);
    }

}
