package filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import Bean.UserBean;
import Util.CookieUtil;
import dao.UserDao;
import dao.impl.UserDaoimpl;

public class AutoLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest request=(HttpServletRequest) req;
			
			//先判断，现在session中有没有那个userBean
			UserBean userBean=(UserBean) request.getSession().getAttribute("userBean");
			
			//还有，有效
			if(userBean!=null){
				chain.doFilter(request, response);
			}else{
				//session失效了，再看cookie
				//来请求时，先取出cookie，但是cookie有很多的key-cookie
				Cookie[] cookies = request.getCookies();
				
				//从一堆cookie里找出我们以前给浏览器发的那个cookie
				Cookie cookie=CookieUtil.findCookie(cookies, "auto_login");
				//第一次来，放行
				if(cookie == null){
					chain.doFilter(request, response);
				}else{
					 String value=cookie.getValue();
					 String username=value.split("#")[0];
					 String password=value.split("#")[1];
					 
					 //完成登陆
					 UserBean user=new UserBean();
					 user.setUsername(username);
					 user.setPassword(password);
					 
					 UserDao dao=new UserDaoimpl();
					 userBean=dao.login(user);
					 
					//存到session中
					 request.getSession().setAttribute("userBean", userBean);
					 
					 chain.doFilter(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			 chain.doFilter(req, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
