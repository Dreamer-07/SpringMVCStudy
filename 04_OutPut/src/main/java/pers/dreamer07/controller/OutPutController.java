package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Map;

/*
*  数据输出
*      方式1：使用 Map/Model/ModelMap 作为方法形参，在方法体中向其中保存的数据最后都会被保存到 request 域中
*                  - 三者关系：无论使用哪一个，最后都会由 BindingAwareModelMap 类完成工作，负责将数据保存到 request 域中
*                        Map(interface(JDK))			  Model(interface(Spring))
                              	 ||								 //
                              	 ||(实现)						//
                              	 \/							   //
                              ModelMap(class)			      //
                                			\\			     //
                                			 \\(继承)       //(实现)
                                			ExtendedModelMap(class)
                                          		     ||(继承)
                                          		     \/
                                             BindingAwareModelMap
*     方式2：使用 ModelAndView 作为方法的返回值
*               - 该对象中既可以保存 Model(给页面的模型数据) 和 View (视图信息，也就是页面地址)
*               - 通过该对象保存的数据，都可以在 request 域中获取
*
*     方式3：向 session 域中保存数据 - 为类添加 @SessionAttributes 注解
*               - 可以指定两个对应的属性值：value 和 types
*                   - value：可以指定多个 String 属性值，代表当向 request 存放数据时，如果 key 和 其中的属性值相同时，就会保存到 session 域中
*                   - types：可以指定多个 Class 属性值，代表当向 request 存放数据时，如果 value 的数据类型和其中的属性值相同时，就会保存到 session 域中
*
* */
@SessionAttributes(value = {"msg"},types = {Integer.class})
@Controller
public class OutPutController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    @RequestMapping("/map")
    public String outMapTest(Map<String,Object> map){
        map.put("msg","EMT"); //给方法形参的map保存数据
        System.out.println(map.getClass()); //class org.springframework.validation.support.BindingAwareModelMap
        System.out.println("控制器方法执行");
        return "success";
    }

    @RequestMapping("/model")
    public String outModelTest(Model model){ //Model 是一个接口
        model.addAttribute("msg","EMT!"); //保存数据到方法形参 model 中
        System.out.println(model.getClass()); //class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/modelMap")
    public String outModelMapTest(ModelMap modelMap){
        modelMap.addAttribute("msg","EMT!!"); //保存数据到方法形参 modelMap 中
        System.out.println(modelMap.getClass()); //class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView testMAV(){
        //创建 ModelAndView 对象时，可以通过有参构造器，可以指定视图名
        //视图名随后会被视图解析器，添加上对应的前缀和后缀，组成真实的资源路径
        ModelAndView mv = new ModelAndView("success");
//        mv.setViewName("success"); //也可以通过 setViewName 方法设置视图名

        //通过 addObject 添加对应的数据，该数据可以通过 request 域获取
        mv.addObject("msg","EMT!!!");
        mv.addObject("age",17);
        return mv;
    }

}
