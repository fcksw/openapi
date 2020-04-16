package com.tuniu.htl.openapi.handler;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuniu.htl.openapi.annos.ApiResponsBody;
import com.tuniu.htl.openapi.model.result.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;


/**
 * 对Controller 方法进行拦截
 *
 * author： andy
 */
@Log4j2
public class ResultHandler implements HandlerMethodReturnValueHandler {


//    private ThreadLocal<ObjectMapper>  mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);

    private final HandlerMethodReturnValueHandler delegate;

    public ResultHandler(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class
    };


//    /**
//     *  ResponseBodyAdvice :  在接口结果返回之前，通常对数据进行加密处理
//     */
//    @Override
//    public boolean supports(MethodParameter returnType, Class aClass) {
//        AnnotatedElement element = returnType.getAnnotatedElement();
//        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        return body;
//    }


    /**
     * HandlerMethodReturnValueHandler ： 接口结果返回之后，对返回结果封装
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
//        AnnotatedElement element = returnType.getAnnotatedElement();
//        log.info("返回值统一处理 support anno  returnType: {}, element: {}", returnType, element);
//        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
//        System.out.println("===========sdfdsf==============="+ returnType.getMethodAnnotation(ApiResponsBody.class));
//        boolean hasJSONAnno = returnType.getMethodAnnotation(ApiResponsBody.class) != null || returnType.getMethodAnnotation(ApiResponsBody.class) != null;
//        return hasJSONAnno;
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
//        modelAndViewContainer.setRequestHandled(true);
//        HttpServletResponse response=nativeWebRequest.getNativeResponse(HttpServletResponse.class);
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//        PrintWriter writer = null;
//        Response res = Response.success().setData(o);
//        try {
//            writer = response.getWriter();
//            writer.write(JSONObject.toJSONString(res));
//            writer.flush();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (writer != null)
//                writer.close();
//        }

        delegate.handleReturnValue(Response.success().setData(o), methodParameter, modelAndViewContainer, nativeWebRequest);
    }

}
