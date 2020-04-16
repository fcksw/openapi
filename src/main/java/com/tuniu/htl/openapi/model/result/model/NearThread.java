package com.tuniu.htl.openapi.model.result.model;

import lombok.Data;

@Data
public class NearThread {

    Outer.Inner inner = new Outer.Inner();


    public static void main(String[] args){

        for (int i = 0; i < 5; i++){
            if (i == 3){
                return;
            }
            System.out.println("1111");
        }

        System.out.println("222");

    }

}
