package DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import Util.JDBCUtil2;

public class DbcpDemo {

	@Test
	public void testDBCP01(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			//1. ��������Դ����
			BasicDataSource dataSource = new BasicDataSource();
			
			
			//������ʲô���͵����ݿ⣬ ���ʵ����ĸ����ݿ� �� �û����� ���롣��
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost/bank");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			
			
			//2. �õ����Ӷ���
			conn = dataSource.getConnection();
			
			
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "kz");
			ps.setInt(2, 1000);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(conn, ps);
		}
		
	}
}
