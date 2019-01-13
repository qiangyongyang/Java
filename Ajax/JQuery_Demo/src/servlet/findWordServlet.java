package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Wordbean;
import dao.WordsDao;
import dao.impl.WordsDaoImpl;

public class findWordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			//1. 先获取参数
			String word = request.getParameter("word");
			System.out.println("word="+word);
			
			//2. 让dao执行查询
			WordsDao dao = new WordsDaoImpl();
			List<Wordbean> list = dao.findWords(word);
			
			for (Wordbean wordBean : list) {
				System.out.println("==="+wordBean.toString());
			}
			
			request.setAttribute("list", list);
			
			//3. 返回数据
			response.setContentType("text/html;charset=utf-8");
			//response.getWriter().write("数据是：");
//			响应这个jsp的页面，全部把它返回给请求者 ， 请求： 浏览器请求 ， 浏览器 看到jsp
			//$jquery ,来请
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

















































