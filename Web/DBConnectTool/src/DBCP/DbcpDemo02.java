package DBCP;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import Util.JDBCUtil2;

public class DbcpDemo02 {
	@Test
	public void testDbcpDemo02() {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			BasicDataSourceFactory bf = new BasicDataSourceFactory();
			Properties pro = new Properties();
			InputStream is = new FileInputStream("src//dbcpconfig.properties");
			pro.load(is);
			DataSource ds = bf.createDataSource(pro);

			con = ds.getConnection();

			String sql = "insert into account values(null,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "skt");
			ps.setInt(2, 10);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil2.release(con, ps);
		}

	}
}
