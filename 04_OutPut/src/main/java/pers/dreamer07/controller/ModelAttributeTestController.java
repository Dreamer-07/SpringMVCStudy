package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.dreamer07.pojo.Book;

/**
 * @author shkstart
 * @create 2020-09-02 16:36
 */
/*
* @ModelAttribute注解的使用
*   1. 作用在方法上：
        - 该方法会比 @RequestMapping 注解的目标方法先进行
        - 在该方法中，使用 Map/Model/ModelMap 作为方法参数
        - 将查询到的 数据库数据封装为 POJO 类对象后，保存在对应的 Map/Model/ModelMap 中
    2. 作用在参数上
        - 作用在对应的 POJO类对象 的方法参数上
        - 通过指定其注解属性值 value ，获取刚刚在于先前方法中保存在 Map/Model/ModelMap 的数据
        - 而 value 的属性值就是刚刚保存数据时使用的 key 值
* */
@Controller
public class ModelAttributeTestController {

    //作用在参数上
    @RequestMapping("/book")
    public String updateBook(@ModelAttribute("book") Book book){
        System.out.println("修改之后的图书信息:" + book); //Book{id=1, bookName='胰脏物语', author='OHHH', price=59.9}
        return "success";
    };

    //作用在方法上
    @ModelAttribute
    public void getBookById(Model model,Integer id){
        //这里先模拟从数据库中查询出对应的数据
        Book book = new Book(id, "胰脏物语", "住野よる", 60.0);
        System.out.println("数据库中查询到的数据：" + book); //Book{id=1, bookName='胰脏物语', author='住野よる', price=60.0}
        //间数据保存在对应的 model 中
        model.addAttribute("book",book);
    }

}
