package com.zdd.service;

import com.zdd.service.feign.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MYCLOUD-PRODUCT",configuration = FeignClientConfig.class)
public interface IUserService {
    @GetMapping("/product/user/{userid}")
    public Object getUser(@PathVariable("userid") Integer userid);
}
