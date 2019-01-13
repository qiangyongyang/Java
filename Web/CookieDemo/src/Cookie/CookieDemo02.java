package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取客户端发送的cookie
		 Cookie[] cookies = request.getCookies();
		 if(cookies!=null){
			 for (Cookie c : cookies) {
				System.out.println(c.getName()+"     "+c.getValue());
			}
		 }
		 
		 
		 	//先写cookie
			Cookie cookie=new Cookie("name","zhangsan");
			
			//这个cookie的有效期。默认情况下，
			//关闭浏览器后，cookie就没了。------>针对没有设置cookie的有效期
			//expiry:有效   ，以秒计时
			//正数：表示这个数字过后，cookie会失效
			//负数：关闭浏览器，cookie将会失效。 默认是-1
			
			cookie.setMaxAge(7*24*60*60);
			
			
			
			response.addCookie(cookie);
			
			Cookie cookie2=new Cookie("age","18");
			response.addCookie(cookie2);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




























































