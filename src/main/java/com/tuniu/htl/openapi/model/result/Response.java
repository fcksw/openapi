package com.tuniu.htl.openapi.model.result;

import lombok.Data;

import java.io.Serializable;

/**
 * api 通用反参
 *
 * @author Andy
 */
public class Response<T> implements Serializable {

    private boolean success;

    private String errorCode;

    private String msg;

    private T data;

    public static <T>Response<T> of(boolean success){
        Response<T> response = new Response<>();
        response.setSuccess(success);
        return response;
    }

    public static <T>Response<T> success(){
        return Response.of(true);
    }

    public static <T>Response<T> fail(){
        return Response.of(false);
    }


    public String getErrorCode() {
        return errorCode;
    }

    public Response setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response setData(T data) {
        this.data = data;
        return this;
    }


    public Response setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }



}
