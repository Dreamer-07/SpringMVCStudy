package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义视图解析器 + 视图对象 - Controller控制器类
 * @author shkstart
 * @create 2020-09-05 18:30
 */
@Controller
public class MyViewResolverController {

    @RequestMapping("/handlePlus")
    public String handlePlus(Model model){
        model.addAttribute("emt","emt");
        model.addAttribute("OHHH",17);
        return "emt:/success";
    }

}
