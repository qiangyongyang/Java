package JDBCDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBCUtil.JDBCUtil2;

public class mianTest {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil2.getConn();
			st=con.createStatement();
			String sql="select *from t_stu";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int age=rs.getInt("age");
				String name=rs.getString("name");
				int id=rs.getInt("id");
				System.out.println(id+"   "+name+"    "+age);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st, rs);
		}
	}
}
