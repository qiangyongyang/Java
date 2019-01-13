package mainTest;

import java.sql.*;

import org.junit.Test;

import Util.JDBCUtil2;

public class testDemo {

	@Test
	public void test02() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil2.getConn();
			//自动提交默认为开启，现在关闭
			conn.setAutoCommit(false);
			
			
			String sql = "update account set money = money - ? where id = ?";
			ps = conn.prepareStatement(sql);

			// 扣钱，id为1的人扣100
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			//int a=10/0;
			
			
			// 加钱，id为2的人加100
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();

			/*while (rs.next()) {

			}*/
			//成功：提交事务
			conn.commit();
		} catch (SQLException e) {
			//失败：回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtil2.release(conn, ps, rs);
		}
	}
}
