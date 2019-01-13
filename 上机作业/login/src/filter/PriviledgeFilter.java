package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import Bean.UserBean;

public class PriviledgeFilter implements Filter {

    public PriviledgeFilter() {
     
    }
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		
		UserBean user =(UserBean)req.getSession().getAttribute("user");
		if(user==null){
			req.setAttribute("msg", "请在登陆后访问");
			req.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
