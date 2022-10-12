package com.infybuzz.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.infybuzz.controller", "com.infybuzz.service"})
@EntityScan("com.infybuzz.entity")
@EnableJpaRepositories("com.infybuzz.repository")
@EnableFeignClients("com.infybuzz.feignclients")
public class StudentServiceApplication {

    @Value("${address.service.url}")
    private String addressServiceUrl;

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

}

