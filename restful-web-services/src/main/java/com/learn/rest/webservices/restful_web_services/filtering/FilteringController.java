package com.learn.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        List<SomeBean> someBean = Arrays.asList(new SomeBean("value1","value2","value3"));

        MappingJacksonValue mappingJacksonValue = getFilter(someBean);
        return mappingJacksonValue;
    }

    private MappingJacksonValue getFilter(List<SomeBean> someBean) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filterOutAllExcept = SimpleBeanPropertyFilter
        .filterOutAllExcept("field1","field2");

        SimpleFilterProvider filter = new SimpleFilterProvider().
        addFilter("SomeBeanFilter", filterOutAllExcept);
        
        mappingJacksonValue.setFilters(filter);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
        List<SomeBean> asList = Arrays.asList(new SomeBean("value4", "value5", "value6"),
        new SomeBean("value7", "value8", "value9"));

        MappingJacksonValue mappingJacksonValue = getFilter(asList);

        return mappingJacksonValue;
    }
}
