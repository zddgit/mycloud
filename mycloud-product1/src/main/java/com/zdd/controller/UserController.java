package com.zdd.controller;

import com.zdd.mapper.UserMapper;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{userid}")
    public Object getUser(@PathVariable Integer userid) {
        System.out.println(discoveryClient.description());
        System.out.println("=========>服务提供者1");
        return userMapper.selectById(userid);
    }
}
