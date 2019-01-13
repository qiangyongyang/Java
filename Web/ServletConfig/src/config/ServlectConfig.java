package config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServlectConfig extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取该servlet配置的参数
		ServletConfig con=getServletConfig();
		String num =con.getInitParameter("number");
		if(num==null){
			throw new IllegalArgumentException("servlect配置时，一定要写num参数");
		}else{
			System.out.println("num....");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}













































