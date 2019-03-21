package com.zdd.controller;

import com.zdd.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    private final String USER_URL = "http://MYCLOUD-PRODUCT/product/user/";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{userid}")
    public Object getUser(@PathVariable Integer userid) {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("MYCLOUD-PRODUCT");
//        System.out.println(
//                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
//                        + "、port = " + serviceInstance.getPort()
//                        + "、serviceId = " + serviceInstance.getServiceId());

        User user = restTemplate.getForObject(USER_URL + userid, User.class);
        return user;
    }
}
