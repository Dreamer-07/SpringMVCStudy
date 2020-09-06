package pers.dreamer07.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pers.dreamer07.bean.Department;

/*
* 操作部门类的 DAO
* */
@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;

	//静态初始化模拟数据库中的数据
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "D-AA"));
		departments.put(102, new Department(102, "D-BB"));
		departments.put(103, new Department(103, "D-CC"));
		departments.put(104, new Department(104, "D-DD"));
		departments.put(105, new Department(105, "D-EE"));
	}

	//查看所有部门信息
	public Collection<Department> getDepartments(){
		return departments.values();
	}

	//根据id查看指定部门信息
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
