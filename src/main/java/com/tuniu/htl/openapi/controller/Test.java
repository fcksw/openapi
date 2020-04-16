package com.tuniu.htl.openapi.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

    public static void main(String[] args) {
        String apiKey = "5iqj9v3776pjb2mun4bij5hfhd";
        String secret = "1dtatmkn52793";
        Date date = new Date();
        Long timestamp = (date.getTime() / 1000);
        String signature = null;
        try {
            String toBeHashed = apiKey + secret + timestamp;
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(toBeHashed.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            signature = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String authHeaderValue = "EAN APIKey=" + apiKey + ",Signature=" + signature + ",timestamp=" + timestamp;
        System.out.println(authHeaderValue);
    }


}
