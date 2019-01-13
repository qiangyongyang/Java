package JDBCDemo;
import java.sql.*;
import org.junit.Test;
import JDBCUtil.JDBCUtil2;
public class TestDemo {
	
	@Test
	public void testQuery() {
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

	@Test
	public void insertQuery() {
		Connection con=null;
		Statement st=null;
		
		try {
			con=JDBCUtil2.getConn();
			st=con.createStatement();
			String sql="insert into t_stu values(null ,'aqx',36)";
			int ans=st.executeUpdate(sql);
			if(ans>0) {
				System.out.println("插入成功");
			}else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st);
		}
	}

	@Test
	public void deleteQuery() {
		Connection con=null;
		Statement st=null;
		
		try {
			con=JDBCUtil2.getConn();
			st=con.createStatement();
			String sql="delete from t_stu where name='aqx'";
			int ans=st.executeUpdate(sql);
			if(ans>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st);
		}
		
	}

	@Test
	public void updateQuery() {
		Connection con=null;
		Statement st=null;
		
		try {
			con=JDBCUtil2.getConn();
			st=con.createStatement();
			String sql="update t_stu set age =26 where name='ls'";
			int ans=st.executeUpdate(sql);
			if(ans>0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st);
		}
	}
}
