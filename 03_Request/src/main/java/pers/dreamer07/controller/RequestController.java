package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.dreamer07.pojo.Book;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.PrintWriter;

/*
* 请求参数处理
*      @RequestParam - 获取请求参数
*      @RequestHeader - 获取请求头中某个 key 的值
*      @CookieValue - 获取某个 cookie 的值
*      POJO 对象绑定请求参数
* */
@Controller
public class RequestController {

    /* 获取请求参数方式1 - 默认方式
    *   将方法的参数名命名为何请求参数名相同即可，会自动接收请求参数，如果没有则为 null
    * */
//    @RequestMapping("/requestValue") //测试获取请求参数
//    public String requestValueTest(String username){
//        System.out.println("username = " + username);
//        return "success";
//    }

    /* 获取请求参数方式2 - 使用 @RequestParam 注解
    *       指定请求参数名即可为对应的参数自动赋值
    *       默认情况下，如果没有带请求参数，会报错
    *       通过设置required的属性可以解决:
    *           - required:该参数是否为必须的，默认为true，如需可以改成false，代表可以为参数值可以不带(null)
*           defaultValue:该参数的默认值
    * */
    @RequestMapping("/requestValue")
    public String requestValueTest(@RequestParam(value = "username",required = false,defaultValue = "1") String username){
        System.out.println("username = " + username);
        return "success";
    }

    /*
    * 获取请求头中的信息 - 使用 @RequestHeader 注解
    *       正常情况下，指定请求头中的 key 值即可
    *       如果获取的是请求头中不存在的 key，那么就会报错
    *       解决方式和 @RequestParam 一样，指定 required 属性值
    *       也可以额外指定 defaultValue 属性值
    * */
    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader(value = "HAHAHA",required = false) String userAgent){
        System.out.println("User-Agent = " + userAgent);
        return "success";
    }

    /*
    * 获取 Cookie 中的值 - 使用 @CookieValue 注解
    *       默认情况下，指定其 value 值为需要获取 cookie 的 key 值即可
    *       但如果请求的 cookie 中没有该 key，就会报错
    *           同样，可以设置器 required 为 false 解决
    *       也可以额外指定 defaultValue 属性值
    * */
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue(value = "JSESSIONID",required = false) String jid){
        System.out.println("JSESSIONID = " + jid);
        return "success";
    }

    //POJO 绑定请求参数
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook(Book book){ //方法参数中指定对应的 POJO 对象
        System.out.println(book);
        return "success";
    }

    //在方法参数中传入原生 API
    @RequestMapping("/API")
    public String testAPI(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.setAttribute("key1","value1");
        return "success";
    }
}
