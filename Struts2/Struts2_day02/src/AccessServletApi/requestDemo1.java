package AccessServletApi;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport; 
/*
 * 访问Servlet的API方式一：完全解耦合的方式
 */
public class requestDemo1 extends ActionSupport{

	@Override
	public String execute() throws Exception {
		//1.接收参数
		//利用Struts2中的对象ActionContext对象
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> map = ac.getParameters();
		for (String key:map.keySet()) {
			String[] values=(String[]) map.get(key);
			System.out.println(key+"   "+ Arrays.toString(values));
		} 
		
		//2.向域对象中存数据
		ac.put("reqName","reqValue");
		ac.getSession().put("sessName", "sessValue");
		ac.getApplication().put("appName", "appValue");
		
		
		return SUCCESS;
	}
	
}




























































































 