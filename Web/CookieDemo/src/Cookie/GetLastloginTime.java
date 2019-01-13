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
		
		response.setContentType("text/html;charset=utf-8");//��ֹ��������
		
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		
		if("admin".equals(name)&&"123".equals(pass)){
			
			//��ȡcookie
			Cookie[] cookies = request.getCookies();
			//���������ҵ�������Ҫ��cookie
			 Cookie cookie=cookieUtil.findCookie(cookies, "last");
			 //��һ�ε�½
			 if(cookie==null){
				 Cookie c=new Cookie("last", System.currentTimeMillis()+"");
				 response.addCookie(c);
				 c.setMaxAge(7*60*24*60);
				 response.getWriter().write("��½�ɹ�..."+name);
			 }else{
				 //ȥ��ǰ��cookie
				 long lastVisitTime=Long.parseLong(cookie.getValue());
				 response.getWriter().write("��½�ɹ�..."+"�ϴ�����ʱ�䣺"+new Date(lastVisitTime));
				 //���õ�¼ʱ��
				 cookie.setValue(System.currentTimeMillis()+"");
				 response.addCookie(cookie);
			 }
			
			
		}else{
			response.getWriter().write("��½ʧ��...");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




































































