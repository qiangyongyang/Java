package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterDemo
 */
public class FilterDemo implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器创建了0.。。");
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("来到过滤器了。。。。");
		chain.doFilter(request, response);
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}
}
