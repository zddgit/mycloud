package com.ribbon.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
//在此处配置的就是指定某个应用名如（MYCLOUD_PRODUCT）应用的负载均衡策略
//在启动类上一定要加上 @RibbonClient(name = "MYCLOUD_PRODUCT", configuration = RibbonRuleConfig.class) 这个注解才能应用
public class RibbonRuleConfig {
    @Bean
    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略
    }
}
