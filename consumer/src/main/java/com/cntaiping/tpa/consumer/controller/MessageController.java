package com.cntaiping.tpa.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/show")
    public String showMessage(@RequestParam("") String name) {
        String forObject = restTemplate.getForObject("http://producer/get?name=" + name, String.class);
        return forObject;
    }

    @GetMapping("/userno1")
    public User getUsersFirst() {
        User[] users = restTemplate.getForObject("http://user-provider/users", User[].class);
        return users[0];
    }

    @GetMapping("/get")
    public String getUsersFirst1() {
        String message = userFeignClient.getMessage1("!1111");
        return message;
    }
}
