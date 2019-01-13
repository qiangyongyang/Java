package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;



public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		System.out.println(name+"  "+pass );
		
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		
		String existName=user.getUsername();
		String existPassword=user.getPassword();
		
		if(name.equals(existName) && pass.equals(existPassword)){
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
