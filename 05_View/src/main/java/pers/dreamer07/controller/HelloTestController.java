package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2020-09-04 11:08
 */
@Controller
public class HelloTestController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /*
    * 返回值前缀 forward 的使用
    *   - 请求转发
    *   - 使用前缀 forward 后，视图解析器不会为我们再拼接路径
    * */
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("handle01");
        /*
        * 建议加上 / 从工程路径下出发寻找路径(绝对路径)
        * 也可以请求转发到另外一个 目标方法
        * */
        return "forward:/handle.jsp";
    }

    /*
    * 返回值时 redirect 前缀的使用
    *   - 重定向
    *   - 使用前缀 redirect 后，视图解析器不会为我们再拼接路径
    *   - 可以直接加上/,SpringMVC会自动帮我们加上工程路径
    * */
    @RequestMapping("/handle02")
    public String handle02(){
        System.out.println("handle02...");
        return "redirect:/handle.jsp";
    }

}
