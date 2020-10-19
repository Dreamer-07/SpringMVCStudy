package pers.dreamer07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.dreamer07.bean.Employee;
import pers.dreamer07.dao.EmployeeDao;

import javax.xml.ws.RequestWrapper;
import java.util.Collection;

/**
 * SpringMVC 处理 Ajax 请求
 * @author EMTKnight
 * @create 2020-09-20
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @Autowired
    private EmployeeDao employeeDao;


    /**
     * @ResponseBody 将返回值的内容作为响应体
     *      - 如果返回值是一个对象 jackson 会帮我们解析成 json 格式
     * @return
     */
    @RequestMapping(value = "/empAll",method = RequestMethod.GET)
    @ResponseBody
    public Collection<Employee> ajaxGetEmpAll(){
        Collection<Employee> employees = employeeDao.getAll();
        return employees;
    }

    /**
     * @RequestBody 使用 1 - 直接获取请求体数据
     * HttpEntity - 获取请求体和所有请求头数据
     * @param body
     * @return
     */
    @RequestMapping("/addEmp")
    public String addEmp(@RequestBody String body, HttpEntity<String> str){
        System.out.println(body);
        System.out.println(str);
        return "success";
    }

    /**
     * @RequestBody 使用 2 - 获取JSON数据后封装为实体类
     * @param body
     * @return
     */
    @RequestMapping("/addEmpBean")
    public String addEmp(@RequestBody Employee body){
        System.out.println(body);
        return "success";
    }

    /**
     * 通过返回 ResponseEntity<String> 返回指定的响应体和响应头
     *      - 泛型 T 为响应体的数据类型
     * @return
     */
    @RequestMapping("/responseEnity")
    public ResponseEntity<String> testResponseEntity(){
        //响应体数据
        String body = "success";
        //自定义响应头
        MultiValueMap<String, String> headers = new HttpHeaders();
        //自定义响应头数据
        headers.set("Set-Cookie","EMT!!=OK");
        //响应状态
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity(body,headers,status);
    }
}
