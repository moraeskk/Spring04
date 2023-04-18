package com.jae.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/ola",method = RequestMethod.GET)
    public String HelloWorld(){

        return "Hello World !!";
    }


}
