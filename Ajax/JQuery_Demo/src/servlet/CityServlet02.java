

package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDao;
import dao.impl.CityDaoImpl;
import net.sf.json.JSONArray;
import Bean.CityBean;
import com.thoughtworks.xstream.XStream;


public class CityServlet02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//1. 获取参数
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			//2 找出所有的城市
			CityDao dao = new CityDaoImpl();
			List<CityBean> list = dao.findCity(pid);
			
			//3. 返回数据。手动拼  --->  把javaBean转化为Json数据
			
			JSONArray jsonArray=JSONArray.fromObject(list);
			String json=jsonArray.toString();
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



























