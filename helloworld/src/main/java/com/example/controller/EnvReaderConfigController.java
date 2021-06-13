package com.example.controller;

import com.example.model.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//@RestController
public class EnvReaderConfigController {
//    @Autowired
//    private Environment env;
//    @RequestMapping("/testEnv")
//    public String testEnv(){
//        return "方法一："+env.getProperty("test.msg");
//    }
//
//    @Value("${test.msg}")
//    private String msg;
//
//    @RequestMapping("/testValue")
//    public String testValue(){
//        return "方法二："+msg;
//    }
//    @Autowired
//    StudentProperties studentProperties;
//
//    @RequestMapping("/testConfigurationProperties")
//    public String test(){
//        return studentProperties.toString();
//    }
}
