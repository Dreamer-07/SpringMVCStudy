package pers.dreamer07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class AjaxController {
    @Autowired
    private EmployeeDao employeeDao;


    /**
     * @ResponseBody 将返回值的内容作为响应体
     *      - 如果返回值是一个对象 jackson 会帮我们解析成 json 格式
     * @return
     */
    @RequestMapping(value = "/ajax/empAll",method = RequestMethod.GET)
    @ResponseBody
    public Collection<Employee> ajaxGetEmpAll(){
        Collection<Employee> employees = employeeDao.getAll();
        return employees;
    }

}
