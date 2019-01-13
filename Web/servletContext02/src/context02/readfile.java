package context02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class readfile
 */
public class readfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*test01();*/
		/*test02();*/
		test03();
	}

	private void test03() throws IOException {
		Properties pro=new Properties();
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("../../file/config.properties");
		pro.load(is);
		String add=pro.getProperty("address");
		System.out.println("address="+add);
	}

	private void test02() throws IOException {
		ServletContext con=getServletContext();
		InputStream is=con.getResourceAsStream("file/config.properties");
		Properties pro=new Properties();
		pro.load(is);
		String add=pro.getProperty("address");
		System.out.println("address="+add);
	}

	private void test01() throws FileNotFoundException, IOException {
		ServletContext con=getServletContext();
		String path=con.getRealPath("file/config.properties");
		System.out.println("path="+path);
		
		Properties pro=new Properties();
		InputStream is=new FileInputStream(path);
		pro.load(is);
		String add=pro.getProperty("address");
		System.out.println("address="+add);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
