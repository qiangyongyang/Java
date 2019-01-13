

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
import Bean.CityBean;
import com.thoughtworks.xstream.XStream;


public class CityServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//1. 获取参数
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			//2 找出所有的城市
			CityDao dao = new CityDaoImpl();
			List<CityBean> list = dao.findCity(pid);
			
			//3. 返回数据。手动拼  ---> XStream  转化 bean对象成 xml
			XStream xStream = new XStream();
			
			//想把id做成属性
			//xStream.useAttributeFor(CityBean.class, "id");
			//设置别名
			xStream.alias("city", CityBean.class);
			//转化一个对象成xml字符串
			String xml = xStream.toXML(list);
			
			//返回数据
			response.setContentType("text/xml;charset=utf-8");
			response.getWriter().write(xml);
			
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



























