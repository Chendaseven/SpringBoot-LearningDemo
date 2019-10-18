package com.atchen.springbootlearning.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "login";
    }

    @RequestMapping("hello1")
    @ResponseBody
    public String index(){
        return "1234";
    }
}
