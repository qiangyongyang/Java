package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoimpl;
import Bean.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String autoLogin = request.getParameter("auto_login");
			UserBean user = new UserBean();
			user.setUsername(username);
			user.setPassword(password);
			
			UserDao dao = new UserDaoimpl();
			UserBean userBean = dao.login(user);
			
			if(userBean != null){
				//页面提交上来的时候，是否选择了自动登陆
				if("on".equals(autoLogin)){
					//发送cookie给客户端
					Cookie cookie=new Cookie("auto",username+"#"+password);
					cookie.setMaxAge(60*60*24*7);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}
				
				//成功了，进入首页
				request.getSession().setAttribute("userBean", userBean);
				response.sendRedirect("index.jsp");
			}else{
				//不成功...
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
