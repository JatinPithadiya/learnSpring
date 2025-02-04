package com.learn.spring.learnspringframework.enterprise.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.spring.learnspringframework.enterprise.example.business.BussinessService;

@Component
public class MyWebController {

    @Autowired
    private BussinessService bussinessService;

    public long returnValueFromBussinessService(){
        return bussinessService.calculateSum();
    }

}
