package crm.web.Interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import crm.web.Bean.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//从session中获取用户数据：
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//判断从session中获取的用户数据是否为空
		if(existUser==null){
			//未登录,给出提示信息，回到登陆页面
			ActionSupport as=(ActionSupport) invocation.getAction();
			as.addActionError("没有登陆，没有权限访问");
			return as.LOGIN;
		}else{
			//已登录
			return invocation.invoke();
		}
	}

}









































