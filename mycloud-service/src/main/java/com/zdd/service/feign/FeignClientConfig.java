package com.zdd.service.feign;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class FeignClientConfig {
    //添加安全验证，登录名和密码
    public BasicAuthenticationInterceptor getBasicAuthenticationInterceptor(){
        return new BasicAuthenticationInterceptor("admin","enjoy");
    }
}
