package com.zdd.service.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
//feign在调用的时候应用的一些配置如：登录，日志级别等等
@Configuration
public class FeignClientConfig {
    //添加安全验证，登录名和密码
//    public BasicAuthenticationInterceptor getBasicAuthenticationInterceptor(){
//        return new BasicAuthenticationInterceptor("admin","enjoy");
//    }
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL ;
    }
}
