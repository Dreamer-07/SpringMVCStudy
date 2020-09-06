package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 第一个控制器类
 * @author shkstart
 * @create 2020-09-01 12:17
 */
@Controller //告诉 SpringMVC 这是一个 控制器组件，可以处理请求
public class MyFirstController {

    /*
    * @RequestMapping：配置接收可以接收的请求地址
    *   / 代表当前工程目录下，映射到 webapp 目录
    * */
    @RequestMapping("hello")
    public String hello(){
        System.out.println("收到请求，正在处理...");
//        return "/WEB-INF/pages/success.jsp"; //使用视图解析器，简化返回的路径
        /*
        *   <property name="prefix" value="/WEB-INF/pages/"></property>
            <property name="suffix" value=".jsp"></property>
        * 该方法的返回的值，最后会被拼接为 /WEB-INF/pages/success.jsp
        * */
        return "success";
    }

}
