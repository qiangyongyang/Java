package DataEncapsulation;

import com.opensymphony.xwork2.ActionSupport;

import Bean.User;
/*
 * 方式二：页面提供表达式的方式
 */
public class UserAction2 extends ActionSupport{
	//提供一个User对象：
	private User user=new User();
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		
		return NONE;
	}
	
}
