package com.g_29.restWebservice.restful_web_service.controller;

import com.g_29.restWebservice.restful_web_service.entity.Helloworld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;


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


    @GetMapping("/hello-world-intl")
    public String helloWorldInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return  messageSource.getMessage("good.morning.message", null,"Default message",locale);
    }

}
