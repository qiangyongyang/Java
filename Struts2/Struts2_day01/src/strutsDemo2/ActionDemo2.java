package strutsDemo2;

import com.opensymphony.xwork2.Action;

/*
 * 实现一个Action接口
 */
public class ActionDemo2 implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("Action实现一个接口");
		return null;
	}

}
