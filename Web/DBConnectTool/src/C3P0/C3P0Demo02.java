package C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo02 {
	
	@Test
	public void testC3P02(){
		Connection con=null;
		PreparedStatement ps=null;
		try {
			
			ComboPooledDataSource ds=new ComboPooledDataSource();
			
			
			con=ds.getConnection();
			String sql="insert into account values(null,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, "c3p0¡ª¡ªproperties");
			ps.setInt(2, 300);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
