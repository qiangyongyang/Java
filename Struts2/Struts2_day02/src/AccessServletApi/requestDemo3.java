package AccessServletApi;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class requestDemo3 extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		Map<String, String[]> map = request.getParameterMap();
		for (String key: map.keySet()) {
			String []values=map.get(key);
			System.out.println(key+"   "+Arrays.toString(values));
		}
		request.setAttribute("reqName", "adfg");
		request.getSession().setAttribute("sessName", "785462");
		return SUCCESS;
	}
	
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	
}
