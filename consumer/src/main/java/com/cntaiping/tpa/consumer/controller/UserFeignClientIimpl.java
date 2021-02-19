package com.cntaiping.tpa.consumer.controller;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author song
 * @date 2021/02/17 20:49
 */
@Component
public class UserFeignClientIimpl implements UserFeignClient {
    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public String getMessage1(String name) {
        return "ces";
    }
}
