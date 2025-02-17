package com.learn.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @GetMapping(path = "/hello-world")
    public String helloworld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("Hello-World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloworldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World %s", name));
    }

}
