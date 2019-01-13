package context03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取登录数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username="+username+"    password="+password);
		
		//2.校检数据
		
		//向客户端输出内容
		PrintWriter pw= response.getWriter();
		if("admin".equals(username)&&"123".equals(password)){
			//System.out.println("成功");
			//pw.write("login success...");
			//
			//2.1累加登陆成功次数
			
			//获取以前存的值，在旧的基础上+1
			Object obj=getServletContext().getAttribute("count");
			//默认是0次
			int totalcount =0;
			if(obj!=null){
				totalcount=(int)obj;
			}
			
			System.out.println("已知登陆成功次数："+totalcount);
			
			getServletContext().setAttribute("count", totalcount+1);
			
			//2.2登陆成功后要跳转页面
			response.setStatus(302);
			response.setHeader("Location", "login_success.html");
		}else{
			//System.out.println("失败");
			pw.write("login fail.....");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}















































