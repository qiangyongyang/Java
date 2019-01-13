package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.PageBean;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class StudentListPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int currentPage=Integer.parseInt(request.getParameter("currentPage"));
			
			//2.根据指定页数，去获取该页页数
			StudentService service=new StudentServiceImpl();
			
			PageBean pagebean=service.findStudentByPage(currentPage);
			request.setAttribute("pagebean", pagebean);
			
			//3.跳转页面
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





















































