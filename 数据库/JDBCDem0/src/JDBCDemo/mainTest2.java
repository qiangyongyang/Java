package JDBCDemo;

import java.sql.DriverManager;

import JDBCUtil.JDBCUtil2;

import java.sql.*;

public class mainTest2 {
	public static void main(String[] args) {
		ResultSet rs=null;
		Connection con=null;
		Statement st=null;
		try {
			con=JDBCUtil2.getConn();
			st=con.createStatement();
			
			String sql="select * from t_stu";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				System.out.println("id="+id+"   name="+name+"   age="+age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con,st,rs);
		}
	}
}
