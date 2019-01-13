package Util;

import java.sql.*;
import org.junit.Test;

public class testDemo {
	
	@Test
	public void testPoool(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		MyDataSource ds=new MyDataSource();
		
		try {
			con=ds.getConnection();
			
			String sql="select *from account";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("name") + "    " + rs.getInt("money"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			ds.addBack(con);
		}
		
	}
}




















































