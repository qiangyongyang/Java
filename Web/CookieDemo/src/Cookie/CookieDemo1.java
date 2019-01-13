package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cookie�ļ�ʵ��
		// Cookie:���͸��ͻ��ˣ����ұ����ڿͻ����ϵ�һ��С����
		response.setContentType("text/html;charset=utf-8"); // �����������

		
		
		
		
		
		// 1.����cookie���ͻ���
		Cookie cookie = new Cookie("aa", "bb");
		// ����Ӧ�����һ��cookie
		response.addCookie(cookie);
		response.getWriter().write("����ɹ��ˡ�������");

		// 2.��ȡ�ͻ��˴����ĵ�cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie c : cookies) {
				String name=c.getName();
				String value=c.getValue();
				System.out.println("cookiename="+name+"     cookievalue="+value);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
















































