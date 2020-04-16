package com.tuniu.htl.openapi.controller;

import com.tuniu.htl.openapi.model.result.model.TestModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class TestController {


    @RequestMapping("/test01")
    public String testStart(@Valid @RequestBody TestModel testModel){
        testModel.getThings().forEach(System.out::println);
        return "success";
    }


    @RequestMapping("/test02")
    public String testException(){

        throw new RuntimeException("this is error");
//        return "success";
    }

}
