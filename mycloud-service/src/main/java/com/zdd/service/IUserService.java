package com.zdd.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "MYCLOUD-PRODUCT",configuration = FeignClientConfig.class) //由于没有启用登录功能所以没有启用登陆配置
@FeignClient(name = "MYCLOUD-PRODUCT")
public interface IUserService {
    @GetMapping("/product/user/{userid}")
    public Object getUser(@PathVariable("userid") Integer userid);
}
