package pers.dreamer07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.dreamer07.bean.Department;
import pers.dreamer07.bean.Employee;
import pers.dreamer07.dao.DepartmentDao;
import pers.dreamer07.dao.EmployeeDao;

import java.util.Collection;

/**
 * @author shkstart
 * @create 2020-09-06 9:20
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工信息
    @RequestMapping(value = "/emps")
    public String getEmpList(Model model){
        Collection<Employee> empList = employeeDao.getAll();
        model.addAttribute("emps",empList);
        return "list";
    }


    @RequestMapping(value = "toAddPage",method = RequestMethod.GET)
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        model.addAttribute("employee",new Employee());
        return "add";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.POST) //添加员工对象
    public String addEmp(Employee employee){
        System.out.println("添加的员工对象 ：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps"; //重定向到另一个目标方法，查询后请求转发到 list.jsp
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET) //根据id查询员工对象
    public String queryEmpById(@PathVariable Integer id,Model model){
        Employee employee = employeeDao.get(id);
        //将部门信息保存到 model 中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //将员工对象保存到 model 中
        model.addAttribute("employee",employee);
        return "edit";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE) //根据id删除员工
    public String deleteEmpById(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.PUT) //修改员工对象
    public String updateEmp(@ModelAttribute("employee") Employee employee){
        employeeDao.save(employee);  //增修合一
        return "redirect:/emps";
    }


    @ModelAttribute //先行方法 - 在修改员工对象前先一步获取对应的员工对象，防止全字段修改时出现的null
    public void updateToQueryEmp(@RequestParam(required = false) Integer id,Model model){
        if(id != null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }
    }
}
