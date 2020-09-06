package pers.dreamer07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 使用 REST 风格管理 Book 模块的请求
 * @author shkstart
 * @create 2020-09-01 22:32
 */
@Controller
@ResponseBody
public class BookController {

    //获取图书信息 - GET请求
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET)
    public String getBook(@PathVariable Integer bookId){
        System.out.println("获取"+bookId+"号图书信息");
        return "success";
    }

    //删除图书信息 - DELETE请求
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Integer bookId){
        System.out.println("删除"+bookId+"号图书信息");
        return "success";
    }

    //更新图书信息 - PUT请求
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.PUT)
    public String updatebook(@PathVariable Integer bookId){
        System.out.println("更新"+bookId+"号图书信息");
        return "success";
    }

    //添加图书信息
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook(){
        System.out.println("添加了新图书");
        return "success";
    }
}
