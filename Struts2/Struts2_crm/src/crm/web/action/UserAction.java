package crm.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.web.Bean.User;
import crm.web.service.CustomerService;
import crm.web.service.UserService;
import crm.web.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//接收数据：实现模型驱动
	private User user=new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	
	/*
	 * 用户登录方法
	 */
	public String login(){
		//创建一个工厂
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service=(UserService) ac.getBean("userService");
		User existUser=service.login(user);
		//调用业务层
		//根据结果页面跳转
		if(existUser==null){
			//失败
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}else{
			//成功
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return SUCCESS;
		}
	}

	
}




























































