package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2020-09-06 8:48
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String test(){
        return "success";
    }

}
