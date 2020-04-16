package com.tuniu.htl.openapi.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "com.tuniu.htl.openapi.config")
@Log4j2
public class EnvConfig {


    @Bean
    @Profile("dev")
    public void runWithDevEnvironment(){
        log.info("实例化dev环境bean , 注解@Profile");

    }





}
