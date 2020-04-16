package com.tuniu.htl.openapi.annos;

import lombok.NonNull;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PointHandlerAnno {
    @NonNull String value();
}
