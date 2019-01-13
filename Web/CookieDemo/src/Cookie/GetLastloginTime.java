package Cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GetLastloginTime extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");//防止中文乱码
		
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		
		if("admin".equals(name)&&"123".equals(pass)){
			
			//获取cookie
			Cookie[] cookies = request.getCookies();
			//从数组里找到我们想要的cookie
			 Cookie cookie=cookieUtil.findCookie(cookies, "last");
			 //第一次登陆
			 if(cookie==null){
				 Cookie c=new Cookie("last", System.currentTimeMillis()+"");
				 response.addCookie(c);
				 c.setMaxAge(7*60*24*60);
				 response.getWriter().write("登陆成功..."+name);
			 }else{
				 //去以前的cookie
				 long lastVisitTime=Long.parseLong(cookie.getValue());
				 response.getWriter().write("登陆成功..."+"上次来访时间："+new Date(lastVisitTime));
				 //重置登录时间
				 cookie.setValue(System.currentTimeMillis()+"");
				 response.addCookie(cookie);
			 }
			
			
		}else{
			response.getWriter().write("登陆失败...");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




































































