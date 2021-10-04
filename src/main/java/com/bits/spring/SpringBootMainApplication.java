package com.bits.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bits")
@EnableConfigurationProperties
public class SpringBootMainApplication {


    public static void main(String[] args) {
        SpringApplication.run(com.bits.spring.SpringBootMainApplication.class, args);
    }

}


