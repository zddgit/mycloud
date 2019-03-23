package com.zdd.controller;

import com.zdd.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerFeignController {
    @Resource
    private IUserService userService;

    @GetMapping("/user/{userid}")
    public Object getUser(@PathVariable Integer userid) {
        return userService.getUser(userid);
    }
}
