package com.bdqn.handler;

import com.bdqn.exception.ActivateException;
import com.bdqn.exception.LoginException;
import com.bdqn.exception.RegisterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice: 控制器增强 (也就是给控制器类增加功能 --异常处理功能)
 *                      位置： 类的上面
 *
 *  特点：必须让框架知道这个注解所在的包名，需要早springmvc配置文件声明组件扫描器
 *  指定：@ControllerAdvice所在的包名
 *
 * */

@ControllerAdvice
public class GlobalExceptionHandler {
    //定义方法，处理发生的异常

    /**
     *  处理异常的方法和控制器方法的定义一样，可以有多个参数，可以有ModelAndView
     *  String,void，对象类型的返回值
     *
     *  形参：Exception，表示Controller中抛出的异常对象
     *  通过形参可以获取发生的异常信息
     *
     * @ExceptionHandler(异常的class)：表示异常的类型，当发生此类型异常时由当前方法处理
     * */
    @ExceptionHandler(value = RegisterException.class)
    public ModelAndView doRegisterException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","注册失败，请重新注册");
        mv.setViewName("result");
        return mv;
    }

    @ExceptionHandler(value = ActivateException.class)
    public ModelAndView doActivateException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","激活失败");
        mv.setViewName("result");
        return mv;
    }

    @ExceptionHandler(value = LoginException.class)
    public ModelAndView doLoginException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","登录失败,请查看密码是否错误或者是否激活");
        mv.addObject("result");
        return mv;
    }

    //处理不知类型的异常
    @ExceptionHandler
    public ModelAndView dotherException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","年龄错误");
        mv.addObject("ex",ex);
        mv.setViewName("defaultError");
        return mv;

    }
}
