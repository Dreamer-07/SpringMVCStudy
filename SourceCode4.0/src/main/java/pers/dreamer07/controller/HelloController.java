package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shkstart
 * @create 2020-09-07 20:25
 */
@Controller
@SessionAttributes("name")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, HttpServletRequest request,String username){
        System.out.println("目标方法执行");
        return "success";
    }

    @ModelAttribute
    public void  modelattribute(Model model){
        System.out.println("先行方法执行");
    }

}
