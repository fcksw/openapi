package com.tuniu.htl.openapi.intercetor;


import com.tuniu.htl.openapi.model.result.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Log4j2
@ControllerAdvice(basePackages = {"com.tuniu.htl.openapi.controller"})
public class RestResponseExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Response handConflict(Exception e){
       log.error("message: {}  cause: {}  e: {}", e.getMessage(), e.getCause(), e);
       return Response.fail().setMsg(e.getMessage());
    }

}
