package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.UserBean;

public class registServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String gender=request.getParameter("gender");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String email=request.getParameter("email");
		String idcard=request.getParameter("idcard");
		String birthday=request.getParameter("birthday");
		String h[]=request.getParameterValues("hobby");
		String info=request.getParameter("info");
		
		String hobby=Arrays.toString(h);
		hobby=hobby.substring(1, hobby.length()-1);
		
		UserBean user=new UserBean(username, gender, password1, email, idcard, birthday, hobby, info);
		System.out.println(user);
		request.getSession().setAttribute("user", user);
		
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
