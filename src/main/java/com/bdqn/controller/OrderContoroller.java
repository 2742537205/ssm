package com.bdqn.controller;


import com.bdqn.entity.ShoppingCat;
import com.bdqn.service.ServiceOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/order",produces="text/plain;charset=utf-8")
public class OrderContoroller {

    @Resource
    ServiceOrder serviceOrder;

    @RequestMapping(value = "/addOrder.do")
    @ResponseBody
    public String addOrders(String address, String username, String phone, HttpServletRequest request){
        //获取全局对象作用域中的购物车
        ServletContext application = request.getServletContext();
        //获取对象
        ShoppingCat shoppingCat = (ShoppingCat) application.getAttribute("list");
        //获取对话域对象
        HttpSession session = request.getSession();
        String uid = (String) session.getAttribute("uid");
        return serviceOrder.addOrder(address,username,phone,uid,shoppingCat);
    }
}
