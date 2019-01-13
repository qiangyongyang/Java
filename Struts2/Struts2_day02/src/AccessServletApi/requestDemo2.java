package AccessServletApi;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/*
 * 访问Servlet的API方式二：原生的方式
 */
public class requestDemo2 extends ActionSupport{

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		for (String key: map.keySet()) {
			String values[]=map.get(key);
			System.out.println(key+"   "+Arrays.toString(values));
		}
		
		//向域对象保存数据
		request.setAttribute("reqName", "name");
		return SUCCESS;
	}
	
}
