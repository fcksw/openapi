package com.tuniu.htl.openapi.config;

import com.tuniu.htl.openapi.handler.ResultHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 统一设置返回参数
 */
@Configuration
@Log4j2
public class ResultConfig implements InitializingBean {


    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean ****");
        List<HandlerMethodReturnValueHandler> originHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(originHandlers.size());
        for (HandlerMethodReturnValueHandler returnValueHandler : originHandlers){
            if (returnValueHandler instanceof RequestResponseBodyMethodProcessor){
                newHandlers.add(new ResultHandler(returnValueHandler));
            }else {
                newHandlers.add(returnValueHandler);
            }
        }
        requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);

    }
}
