package com.learn.spring.learnspringframework.enterprise.example.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.spring.learnspringframework.enterprise.example.data.DataService;

@Component
public class BussinessService {

    @Autowired
    private DataService dataService;

    public long calculateSum(){
        //Create streams from list and perform sum of elements in it and return it.
        return dataService.getData().stream().reduce(Integer::sum).get();
    }
}
