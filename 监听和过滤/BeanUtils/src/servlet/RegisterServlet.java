package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Bean.UserBean;

public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try {
			UserBean bean=new UserBean();
			Map map=request.getParameterMap();
			BeanUtils.populate(bean, map);
			System.out.println("beanutils="+bean.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		UserBean bean=new UserBean();
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setEmail(email);
		bean.setPhone(phone);
		bean.setAddress(address);
		
		System.out.println("bean="+bean.toString());*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
