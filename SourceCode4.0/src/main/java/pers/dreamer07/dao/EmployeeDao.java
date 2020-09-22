package pers.dreamer07.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.dreamer07.bean.Department;
import pers.dreamer07.bean.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/*
* 操作 员工类 的DAO
* */
@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired //自动注入
	private DepartmentDao departmentDao;

	//静态初始化模拟数据库数据
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
	}
	
	private static Integer initId = 1006;

	//保存/修改 员工对象
	public void save(Employee employee){
		if(employee.getId() == null){ //如果该员工有id就是修改，没有就是添加
			employee.setId(initId++);
		}

		//根据部门id，调用 departmentDao.getDepartment 注入部门属性
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	//查询所有员工
	public Collection<Employee> getAll(){
		return employees.values();
	}

	//根据id查询员工
	public Employee get(Integer id){
		return employees.get(id);
	}

	//根据id删除员工
	public void delete(Integer id){
		employees.remove(id);
	}
}
