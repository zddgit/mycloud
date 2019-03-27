package com.zdd.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zdd.User;
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
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object getUser(@PathVariable Integer userid) {
        System.out.println(discoveryClient.description());
        System.out.println("=========>服务提供者hystrix");
        User user = userMapper.selectById(userid);
        if(user==null){
            throw new RuntimeException("此用户不存在");
        }
        return user;
    }
    private Object getFallback(Integer userid){
        System.out.println(userid);
        User user = new User();
        user.setId(9999);
        user.setName("HystrixName");
        return user;
    }

}
