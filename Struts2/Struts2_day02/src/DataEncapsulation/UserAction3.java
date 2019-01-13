package DataEncapsulation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Bean.User;
/*
 * 方式三：模型驱动-采用模型驱动的方式(最常用)
 */
public class UserAction3 extends ActionSupport implements ModelDriven<User>{
	
	private User user=new User();

	@Override
	public User getModel() {
		return user;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}

	
}
