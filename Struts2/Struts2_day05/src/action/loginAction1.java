package action;

import com.opensymphony.xwork2.ActionSupport;
/*
 * 数据校验：
 * 		继承ActionSupport之后有：数据校验，国际化，设置错误信息等
 */
public class loginAction1 extends ActionSupport{
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		
		return NONE;
	}
	
	//数据校验的方法：
	@Override
	public void validate() {
		//判断用户名不能为空：
		if(username==null || username.trim().length()==0){
			//阻止execute执行
			this.addFieldError("username", "用户名不能为空 ");
		}
		//判断密码
		if(password.trim().length()<5){
			//阻止execute执行
			this.addFieldError("password", "密码小于5位");
		}
	}
	
	
	//争对方法的校验
	public void validateExecute(){
		if(password.trim().length()<6 || password.trim().length()>12 ){
			this.addFieldError("password", "密码必须在6到12位之间 ");
		}
	}
	
}




























