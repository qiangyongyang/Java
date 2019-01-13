package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class addServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		try {
			//1.获取客户端提交的数据
			String sname=request.getParameter("sname");
			String gender=request.getParameter("gender");
			String phone=request.getParameter("phone");
			String birthday=request.getParameter("birthday");
			String []h=request.getParameterValues("hobby");
			String info=request.getParameter("info");
			String hobby=Arrays.toString(h);
			//hobby=hobby.substring(1, hobby.length()-1);
			//2.添加到数据库
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student stu=new Student(sname, gender, phone, hobby, info, date);
					
			
			StudentService service=new StudentServiceImpl(); 
			service.insert(stu);
			 
			//3.跳转到列表页
		
			request.getRequestDispatcher("StudentListPageServlet?currentPage=1").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
