package com.linjr;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {PageHelperAutoConfiguration.class})
@MapperScan("com.linjr.mapper")
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class RsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsWebApplication.class, args);
    }

}
