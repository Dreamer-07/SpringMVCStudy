package pers.dreamer07.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

/*
* 员工类
* */
public class Employee {

	private Integer id;

	@NotEmpty
	@Length(min = 6,max = 30)
	private String lastName;

	@Email
	private String email;

	//1 male, 0 female
	private Integer gender;

	@JsonIgnore //对应类的对象被解析 Json 格式后，不显示该属性的值
	private Department department;

	/*
	* 使用 @DateTimeFormat 指定请求参数中日期的格式
	* 使用 @Past 指定属性值必须是过去的时间
	* */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@JsonFormat(pattern = "yyyy-MM-dd") //当对应类的对象被解析成 Json 格式后，将该属性值格式化成指定格式
	private Date birth = new Date(); //生日

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Department department, Date birth) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
		this.birth = birth;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", department=" + department +
				", birth=" + birth +
				'}';
	}
}
