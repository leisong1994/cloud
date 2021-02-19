package com.cntaiping.tpa.consumer.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author song
 * @date 2021/02/17 20:25
 */
@FeignClient(value = "producer", fallback = UserFeignClientIimpl.class) // 指定微服务实例名称
@Component
public interface UserFeignClient {

    @GetMapping("/users") // 指定调用微服务的服务地址
    public List<User> getList();

    @GetMapping("/get")
    String getMessage1(@RequestParam("name") String name);
}
