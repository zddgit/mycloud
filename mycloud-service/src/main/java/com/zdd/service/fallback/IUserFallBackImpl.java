package com.zdd.service.fallback;

import com.zdd.User;
import com.zdd.service.IUserService;
import org.springframework.stereotype.Component;

@Component
public class IUserFallBackImpl implements IUserService {
    @Override
    public Object getUser(Integer userid) {
        User user = new User();
        user.setId(-1);
        user.setName("aaaa");
        return user;
    }
}
