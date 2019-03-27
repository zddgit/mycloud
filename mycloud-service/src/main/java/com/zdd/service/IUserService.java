package com.zdd.service;

import com.zdd.service.fallback.IUserFallBackImpl;
import com.zdd.service.fallback.IUserServiceFallBackFactory;
import com.zdd.service.feign.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//注释的和没有注释的两个用法都可以实现服务的熔断
//@FeignClient(name = "MYCLOUD-PRODUCT",configuration = FeignClientConfig.class,fallbackFactory= IUserServiceFallBackFactory.class)
@FeignClient(name = "MYCLOUD-PRODUCT",configuration = FeignClientConfig.class,fallback= IUserFallBackImpl.class)
public interface IUserService {
    @GetMapping("/product/user/{userid}")
    public Object getUser(@PathVariable("userid") Integer userid);
}
