package com.linjr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RsWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsWebapiApplication.class, args);
    }

}
