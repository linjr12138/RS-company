package com.linjr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RsThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsThymeleafApplication.class, args);
    }

}
