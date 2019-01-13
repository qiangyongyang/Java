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
			//�Զ��ύĬ��Ϊ���������ڹر�
			conn.setAutoCommit(false);
			
			
			String sql = "update account set money = money - ? where id = ?";
			ps = conn.prepareStatement(sql);

			// ��Ǯ��idΪ1���˿�100
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			//int a=10/0;
			
			
			// ��Ǯ��idΪ2���˼�100
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();

			/*while (rs.next()) {

			}*/
			//�ɹ����ύ����
			conn.commit();
		} catch (SQLException e) {
			//ʧ�ܣ��ع�
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
