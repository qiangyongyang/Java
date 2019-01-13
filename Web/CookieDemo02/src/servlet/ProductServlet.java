package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		Cookie[]cookies=request.getCookies();
		Cookie cookie=cookieUtil.findCookie(cookies,"history");
		if(cookie==null){
			Cookie c=new Cookie("history",id);
			response.addCookie(c);
		}else{
			String ids=cookie.getValue();
			cookie.setValue(id+"#"+ids);
			response.addCookie(cookie);
	
		}
		
		response.sendRedirect("product_info.htm");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}






























































