package strutsDemo2;

import com.opensymphony.xwork2.ActionSupport;

/*
 * Action继承ActionSupport类
 */
public class ActionDemo3 extends ActionSupport{
	@Override 
	public String execute() throws Exception {
		System.out.println("Action继承ActionSupport类");
		return NONE;
	}	
}









































































