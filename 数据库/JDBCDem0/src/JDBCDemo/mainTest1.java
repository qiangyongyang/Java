package JDBCDemo;

import java.sql.DriverManager;

import java.sql.*;

public class mainTest1 {
	public static void main(String[] args) {
		try {
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());   可以不用注册数据库
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root");
			Statement st=con.createStatement();
			
			String sql="select * from t_stu";
ResultSe			t rs=st.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				System.out.println("id="+id+"   name="+name+"   age="+age);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
