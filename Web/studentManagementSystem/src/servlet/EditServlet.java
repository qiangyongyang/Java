package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int sid=Integer.parseInt(request.getParameter("sid"));
			
			//2.查询学生数据
			StudentService service=new StudentServiceImpl();
			Student stu=service.findStudentById(sid);
			
			//3.显示数据
				//存数据
				request.setAttribute("stu", stu);
				//跳转
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
