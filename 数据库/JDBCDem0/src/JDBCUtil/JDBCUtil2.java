package JDBCUtil;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil2 {
	
    static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password=null;
	
	static{
		try {
			Properties properties = new Properties();
			InputStream is =JDBCUtil2.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(is);
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			//Class.forName(driverClass);   可以不用注册
			conn = DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}

	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
