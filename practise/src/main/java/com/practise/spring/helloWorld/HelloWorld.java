package com.practise.spring.helloWorld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {


    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/helloBean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/helloBean/path/{message}")
    public HelloWorldBean helloWorldBean(@PathVariable String message){
        return new HelloWorldBean(message);
    }
}
