package pers.dreamer07.converterImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pers.dreamer07.bean.Employee;
import pers.dreamer07.dao.DepartmentDao;

/**
 * 实现将 String 类型转换为 Employee 类型的自定义类型转换器
 *      - Converter<S,T>
 *          - S:原类型
 *          - T:转换后的类型
 * @author shkstart
 * @create 2020-09-12 11:46
 */
public class StringToEmpConverter implements Converter<String, Employee> {

    @Autowired
    private DepartmentDao departmentDao;

    @Override //核心执行方法
    public Employee convert(String source) {
        Employee employee = new Employee();
        //如果字符串中包含-
        if(source.contains("-")){
            //empName-email-gender-deptId
            String[] split = source.split("-");
            //封装对应的信息到 Emp 对象中
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
        }
        return employee;
    }

}
