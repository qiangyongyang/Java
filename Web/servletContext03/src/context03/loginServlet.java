package context03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��¼����
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username="+username+"    password="+password);
		
		//2.У������
		
		//��ͻ����������
		PrintWriter pw= response.getWriter();
		if("admin".equals(username)&&"123".equals(password)){
			//System.out.println("�ɹ�");
			//pw.write("login success...");
			//
			//2.1�ۼӵ�½�ɹ�����
			
			//��ȡ��ǰ���ֵ���ھɵĻ�����+1
			Object obj=getServletContext().getAttribute("count");
			//Ĭ����0��
			int totalcount =0;
			if(obj!=null){
				totalcount=(int)obj;
			}
			
			System.out.println("��֪��½�ɹ�������"+totalcount);
			
			getServletContext().setAttribute("count", totalcount+1);
			
			//2.2��½�ɹ���Ҫ��תҳ��
			response.setStatus(302);
			response.setHeader("Location", "login_success.html");
		}else{
			//System.out.println("ʧ��");
			pw.write("login fail.....");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}















































