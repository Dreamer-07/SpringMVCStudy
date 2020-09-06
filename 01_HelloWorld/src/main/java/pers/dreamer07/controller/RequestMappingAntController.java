package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping注解对于请求地址的Ant风格的模糊匹配
 * Ant风格：之前自动构建工具Ant匹配资源时使用的一套通配符参数
 * 通配符参数：
        ?：匹配文件名中的一个字符，该字符有且只有一个
        *：匹配文件名中的任意字符和一层路径，对应位置上的字符可以是0个
        **：匹配多层路径，对应位置上的字符可以是0个
 * 优先级：精确 > ? > * > **
 * @author shkstart
 * @create 2020-09-01 20:49
 */
@Controller
public class RequestMappingAntController {


    @RequestMapping("/antTest01") //精准匹配
    public String antTest01(){
        System.out.println("antTest01....");
        return "success";
    }

    /*
    * ?匹配一个字符，0个或多个都不写
    * */
    @RequestMapping("/antTest0?")
    public String antTest02(){
        System.out.println("antTest02....");
        return "success";
    }

    /*
    * *匹配多个字符，且可以代表一层路径 - *的位置上可以为空
    * */
    @RequestMapping("/a*/antTest0*")
    public String antTest03(){
        System.out.println("antTest03....");
        return "success";
    }

    /*
    * **匹配多层路径 - **可以为空
    * */
    @RequestMapping("/a/**/antTest")
    public String antTest04(){
        System.out.println("antTest04....");
        return "success";
    }

    /*
     * @PathVariable 可以获取路径上的占位符
     * 在声明 @RequestMapping 的路径时可以在任意路径的地方写一个{变量名}
     * */
    @RequestMapping("/{username}/pathVariable{abc}")
    public String pathVariableTest(@PathVariable("abc") String username){
        System.out.println("username = " + username);
        return "success";
    }
}
