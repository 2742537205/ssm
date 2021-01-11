package com.bdqn.controller;


import com.bdqn.entity.Product;
import com.bdqn.entity.ShoppingCat;
import com.bdqn.service.ServiceProduct;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/pro")
public class ProductController {
    //自动注入逻辑层商品对象
    @Resource
    ServiceProduct sp;

    //商品查询
    @RequestMapping(value = "/info.do")
    public ModelAndView hot(){
        //调用逻辑层的查询最热商品方法
        List<Product> productList = sp.hots();
        //调用逻辑层的查询最新商品方法
        List<Product> productList1 =sp.nets();

        ModelAndView mv = new ModelAndView();
        mv.addObject("hot",productList);
        mv.addObject("news",productList1);
        mv.setViewName("forward:/jsp/index.jsp");
        return mv;
    }
    //查询指定商品信息
    @RequestMapping(value = "/pInfo.do")
    public ModelAndView pInfo(Integer pid){
        //调用逻辑层的查询最热商品方法
        Product pList = sp.pInfo(pid);

        ModelAndView mv = new ModelAndView();
        mv.addObject("pInfo",pList);
        mv.setViewName("forward:/jsp/product_info.jsp");
        return mv;
    }

    //分页查询数据
    @RequestMapping(value = "/pageInfo.do")
    @ResponseBody
    public Object page(Integer num){
        List<Product> pList = sp.pageInfo(num);
        return pList;
    }

    //查询指定商品
    @RequestMapping(value = "/PInfoList.do")
    public ModelAndView pInfoList(Integer pid, Integer num){
        //调用逻辑层查询商品的方法
        ShoppingCat productList = sp.pInfoList(pid,num);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",productList);
        mv.setViewName("forward:/jsp/cart.jsp");
        return mv;
    }

    //删除指定商品
    @RequestMapping(value = "/deleteShop.do")
    public ModelAndView deleteShop(String pid){
        //调用逻辑层的删除商品的方法
        ShoppingCat shoppingCat = sp.delte(pid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",shoppingCat);
        mv.setViewName("forward:/jsp/cart.jsp");
        return mv;
    }

    //将购物车里的数据显示到订单页面中
    @RequestMapping(value = "/orderInfoView")
    public ModelAndView orderInfoView(HttpServletRequest request){
        ShoppingCat shoppingCat = sp.orderInfoView();
        //将存放所有商品(相当于购物车)存储到全局作用域对象中
        ServletContext context = request.getServletContext();
        context.setAttribute("list",shoppingCat);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",shoppingCat);
        mv.setViewName("forward:/jsp/order_info.jsp");
        return mv;
    }

}
