package test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class TestProcedure {
	@Test
	public void test1() throws Exception{
		 //注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.获取连接
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "scott";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3.获取执行SQL的statement
		String sql = "{call proc_gettotalsal(?,?)}";
		CallableStatement state = conn.prepareCall(sql);
		//设置输入参数
		state.setInt(1, 7788);
		//注册输出参数
		state.registerOutParameter(2, OracleTypes.NUMBER);
		
		//4.执行statement
		state.execute();
		
		//5.获取执行结果
		int totalsal=state.getInt(2);
		
		System.out.println("工资:"+totalsal);
		
		//6.释放资源
		state.close();
		conn.close();
	 }
}









































































































