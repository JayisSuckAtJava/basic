package com.example.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MethodController {
    
    @GetMapping("req/get")
    public String get(){
        return "GET";
    }
    @PostMapping("req/post")
    public String post(){
        return "POST";
    }
    @PutMapping("req/put")
    public String put(){
        return "PUT";
    }
    @DeleteMapping("req/delete")
    public String delete(){
        return "DELETE";
    }
}
