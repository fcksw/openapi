package com.tuniu.htl.openapi.annos;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiResponsBody {
    String type() default "json";
}