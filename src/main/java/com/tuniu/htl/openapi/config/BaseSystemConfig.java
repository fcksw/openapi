package com.tuniu.htl.openapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class BaseSystemConfig implements InitializingBean, EnvironmentAware {


    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSystemConfig.class);

    private Environment environment;

    /**
     * 开发或本地环境
     */

    private boolean local = false;

    /**
     * 生产或预发布环境
     */
    private boolean product = false;

    private String envName;




    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("当前系统环境配置名称  {}  InitializingBean", envName);

    }

    private String getActiveProfiles(){
        String[] activeProfiles = this.environment.getActiveProfiles();
        if (null != activeProfiles && activeProfiles.length > 0){
            return activeProfiles[0];
        }
        return null;
    }


    public Environment getEnvironment() {
        return environment;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }



    public boolean isProduct() {
        return product;
    }

    public void setProduct(boolean product) {
        this.product = product;
    }

    public boolean isLocal() {
        return local;
    }

    public String getEnvName() {
        return envName;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

}
