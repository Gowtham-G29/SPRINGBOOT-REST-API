package com.g_29.restWebservice.restful_web_service.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public ResponseEntity<MappingJacksonValue> filtering(){
        SomeBean someBean=new SomeBean("Value1","value2","Value3");

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
                .filterOutAllExcept("field2","field1");
        FilterProvider filterProvider=new SimpleFilterProvider()
                .addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filterProvider);

        return ResponseEntity.status(200).body(mappingJacksonValue);

    }


}
