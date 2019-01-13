package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ȡ�ͻ��˷��͵�cookie
		 Cookie[] cookies = request.getCookies();
		 if(cookies!=null){
			 for (Cookie c : cookies) {
				System.out.println(c.getName()+"     "+c.getValue());
			}
		 }
		 
		 
		 	//��дcookie
			Cookie cookie=new Cookie("name","zhangsan");
			
			//���cookie����Ч�ڡ�Ĭ������£�
			//�ر��������cookie��û�ˡ�------>���û������cookie����Ч��
			//expiry:��Ч   �������ʱ
			//��������ʾ������ֹ���cookie��ʧЧ
			//�������ر��������cookie����ʧЧ�� Ĭ����-1
			
			cookie.setMaxAge(7*24*60*60);
			
			
			
			response.addCookie(cookie);
			
			Cookie cookie2=new Cookie("age","18");
			response.addCookie(cookie2);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




























































