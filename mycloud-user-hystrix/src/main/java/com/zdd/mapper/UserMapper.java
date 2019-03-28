package com.zdd.mapper;

import com.zdd.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select id,name from user where id = #{userId}")
    User selectById(Integer userId);
}
