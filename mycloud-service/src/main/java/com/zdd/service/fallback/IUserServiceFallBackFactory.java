package com.zdd.service.fallback;

import com.zdd.User;
import com.zdd.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class IUserServiceFallBackFactory implements FallbackFactory<IUserService> {
    @Override
    public IUserService create(Throwable throwable) {
        return new IUserService(){
            @Override
            public Object getUser(Integer userid) {
                User user = new User();
                user.setName("hystrix");
                user.setId(0);
                return user;
            }
        };
    }
}
