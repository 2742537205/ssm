package com.bdqn.service;

import com.bdqn.dao.UDao;
import com.bdqn.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceUserImpl implements ServiceUser{

    @Resource
    UDao uDao;

    @Override
    public String register(User user) {
        //调用逻辑层方法
        int count = uDao.register(user);
        if(count<=0){
            return "false";
        }else{
            return "true";
        }
    }

    @Override
    public String activateCode(String code) {
        int count = uDao.activateCode(code);
        if(count<=0){
            return "false";
        }else{
            return "true";
        }
    }

    @Override
    public String login(String username,String pwd) {
        String uid = uDao.login(username,pwd);
        return uid;
    }
}
