package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.PageBean;
import Bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class SearchServlet extends HttpServlet {
	
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		if (currPage == null) {
			currPage = 1;
		}
		this.currPage = currPage;
	}

	// 使用set方法接受每页显示记录数
	private Integer pageSize = 5;

	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 5;
		}
		this.pageSize = pageSize;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {				
			//1.获取查询关键字
			String sname=request.getParameter("sname");
			String gender=request.getParameter("gender");
			//2.找service去查询
			StudentService service =new StudentServiceImpl();
			List<Student>list=service.searchStudent(sname, gender);
			
			//3.跳转界面
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}