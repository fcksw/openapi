package com.tuniu.htl.openapi.annos.impl;

import com.tuniu.htl.openapi.annos.PointHandlerAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PointHanlderImpl implements PointHandlerAnno, InvocationHandler {


    @Override
    public String value() {

        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
