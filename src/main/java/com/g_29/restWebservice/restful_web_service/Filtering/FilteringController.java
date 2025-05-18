package com.g_29.restWebservice.restful_web_service.Filtering;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public ResponseEntity<SomeBean> filtering(){

        SomeBean someBean=new SomeBean("Value1","value2","Value3");

        return ResponseEntity.status(200).body(someBean);

    }
}
