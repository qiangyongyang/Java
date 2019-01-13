package DataEncapsulation;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import Bean.User;

/*
 * 数据封装的方式一：提供属性的set方法的方式
 */
public class UserAction1 extends ActionSupport{
	private String username;
	private String password;
	private Integer age;
	private Date birthday;
	private Double salary;
	//提供set方法
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(username);
		System.out.println(password);
		System.out.println(age);
		System.out.println(birthday);
		System.out.println(salary);
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(age);
		user.setBirthday(birthday);
		user.setSalary(salary);
		
		return NONE;
	}
	
}















































































