package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import service.impl.StudentServiceImpl;

public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.接受id
			int sid=Integer.parseInt(request.getParameter("sid"));
			
			//2.执行删除
			StudentService service =new StudentServiceImpl();
			service.delete(sid);
			
			//3.跳转到列表页
			request.getRequestDispatcher("StudentListPageServlet?currentPage=1").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
