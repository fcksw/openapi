package com.tuniu.htl.openapi.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Log4j2
@Configuration
public class InitCacheConfig {


    @PostConstruct
    public void init(){
        log.info("init cache!! 初始化缓存   注解 @PostConstruct");
    }



  }
