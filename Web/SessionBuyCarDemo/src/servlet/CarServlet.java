package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡҪ��ӵ����ﳵ����Ʒid
		int id=Integer.parseInt(request.getParameter("id"));  //0  -  1  -  2   - 3 ......
		String[] names={"iphone7","huawei","xiaomi","nokie","sangsung"};
		String name=names[id];
		//2.��ȡ���ﳵ��Ŷ�����session
		
		//��һ��map���󣨹��ﳵ���浽Session���ֻ��һ�Ρ�
		Map<String, Integer> map=(Map<String,Integer>)request.getSession().getAttribute("cart");
		if(map==null){
			map=new LinkedHashMap<String,Integer>();
			request.getSession().setAttribute("cart", map);
		}
		
		//3.�жϹ��ﳵ����û�������Ʒ
		if(map.containsKey(name)){
			map.put(name, map.get(name)+1);
		}else{
			map.put(name, 1);
		}
		
		//4.������棬��ת
		response.getWriter().write("<a href='product_list.jsp'>��������</a><br/>");
		response.getWriter().write("<a href='cart.jsp'>ȥ���ﳵ����</a><br/>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



























































