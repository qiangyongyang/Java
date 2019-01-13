package C3P0;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3P0Demo {

	@Test
	public void testC3P0(){
		Connection con=null;
		PreparedStatement ps=null;
		try {
			
			ComboPooledDataSource ds=new ComboPooledDataSource();
			
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost/bank");
			ds.setUser("root");
			ds.setPassword("root");
			
			con=ds.getConnection();
			String sql="insert into account values(null,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, "c3p0");
			ps.setInt(2, 300);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}












































































