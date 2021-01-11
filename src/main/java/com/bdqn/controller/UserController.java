package com.bdqn.controller;


import com.bdqn.entity.User;
import com.bdqn.exception.LoginException;
import com.bdqn.exception.MyUserException;
import com.bdqn.exception.RegisterException;
import com.bdqn.service.ServiceUser;

import com.bdqn.util.MyEmail;
import com.bdqn.util.MyRandom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user",produces="text/plain;charset=utf-8")
public class UserController {

    @Resource
    ServiceUser serviceUser;

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public ModelAndView login(String username,String password,HttpServletRequest request){
        String rs = serviceUser.login(username,password);
        HttpSession session = request.getSession();
        session.setAttribute("uid",rs);
        ModelAndView mv = new ModelAndView();
        mv.addObject("username",username);
        mv.setViewName("redirect:/pro/info.do");
        return mv;
    }

    @RequestMapping(value = "/register.do")
    @ResponseBody
    public String register(User u,HttpServletRequest request) throws MyUserException ,Exception{
        //调用生成随机id的工具方法
        u.setCode(MyRandom.UID());
        u.setuId(MyRandom.UID());
        String rs = serviceUser.register(u);
        if(rs.equals("false"))
        {
            throw new RegisterException("注册失败");
        }

        //调用发送邮箱的方法
        MyEmail.sendMail(u.getEmail(),u.getCode());
        return "注册成功，请通过邮箱进行激活";
    }

    @RequestMapping(value = "/activate.do")
    public ModelAndView activate(HttpServletRequest request) throws Exception{
        //获取参数值
        String code = request.getParameter("code");
        //调用逻辑层的激活方法
        if(serviceUser.activateCode(code).equals("false"))
        {
            throw new RegisterException("激活失败，请查看激活码是否正确");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","激活成功");
        mv.setViewName("result");
        return mv;
    }

}
