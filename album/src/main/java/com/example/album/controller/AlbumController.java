package com.example.album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AlbumController {

    @GetMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public Object hello(){
        return "hello";
    }


    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/test",produces = "application/json;charset=UTF-8")
    public Object test(){
        return restTemplate.getForObject("http://login/userList", String.class);
    }



}
