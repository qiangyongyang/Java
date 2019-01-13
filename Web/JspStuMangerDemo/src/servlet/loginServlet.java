package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import dao.UserDao;
import dao.impl.StuDaoImpl;
import dao.impl.UserDaoImpl;
import domain.Student;
public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDao dao=new UserDaoImpl();
		boolean isSuccess=dao.login(username, password);
		if(isSuccess){
			
			
			StuDao studao=new StuDaoImpl();
			List<Student> list=studao.findAll();
			
			
			request.getSession().setAttribute("list", list);

			response.sendRedirect("stu_list.jsp");
		}else{
			response.getWriter().write("�û������������");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





























































