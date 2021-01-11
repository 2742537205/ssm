package com.bdqn.service;

import com.bdqn.entity.User;
import org.apache.ibatis.annotations.Param;

public interface ServiceUser {
    //注册用户
    String register(User user);
    //激活用户
    String activateCode(String code);
    //登录
    String login(String username,String pwd);
}
