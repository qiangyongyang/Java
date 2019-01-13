package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cookie的简单实用
		// Cookie:发送给客户端，并且保存在客户端上的一份小数据
		response.setContentType("text/html;charset=utf-8"); // 解决中文乱码

		
		
		
		
		
		// 1.发送cookie给客户端
		Cookie cookie = new Cookie("aa", "bb");
		// 给响应，添加一个cookie
		response.addCookie(cookie);
		response.getWriter().write("请求成功了。。。。");

		// 2.获取客户端带来的的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie c : cookies) {
				String name=c.getName();
				String value=c.getValue();
				System.out.println("cookiename="+name+"     cookievalue="+value);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
















































