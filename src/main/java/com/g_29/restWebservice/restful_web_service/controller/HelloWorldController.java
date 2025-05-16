package com.g_29.restWebservice.restful_web_service.controller;

import com.g_29.restWebservice.restful_web_service.model.Helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public Helloworld helloWorldBean(){
        return new Helloworld("Hello World");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public Helloworld helloWorldPathVariable(@PathVariable String name){
         return new Helloworld("Hello world "+name);
    }

}
