package com.zdd;

import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "MYCLOUD_PRODUCT", configuration = RibbonRuleConfig.class)
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //在这里配置的规则是全局的，不配置默认轮询
    @Bean
    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略
    }
}
