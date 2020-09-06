package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.print.DocFlavor;

/**
 * 作用在类上的 @RequestMapping
 * @author shkstart
 * @create 2020-09-01 15:41
 */
@RequestMapping("/emt")
@Controller
public class RequestMappingTestController {

    @RequestMapping("/haha") //访问该方法的请求路径仍然是 /emt/haha，而不是/emthaha
    public String haha(){
        System.out.println("收到请求，正在处理...");
        return "success";
    }

    /*
    * 使用 method 后，代表该方法只接收指定请求方式的请求
    * 可以指定多个，如：{RequestMethod.POST,RequestMethod.GET}
    * */
    @RequestMapping(value = "/method",method = RequestMethod.POST)
    public String method(){
        return "success";
    }

    /*
    * params：规定请求的参数
    * */
    @RequestMapping(value = "params",params = {"username=111","!age","password"})
    public String params(){
        return "success";
    }

    /*
    * headers：规定请求头的参数 - 这里只允许火狐游览器访问
    * */
    @RequestMapping(value = "headers",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0"})
    public String headers(){
        return "success";
    }



}
