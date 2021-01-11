package com.bdqn.dao;

import com.bdqn.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UDao {
    //注册用户
    int register(User user);
    //激活用户
    int activateCode(@Param("code") String code);
    //登录
    String login(@Param("username") String username,@Param("password") String password);
}
