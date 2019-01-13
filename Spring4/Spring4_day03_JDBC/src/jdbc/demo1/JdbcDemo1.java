package jdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemo1 {
	@Test
	public void demo1(){
		//创建连接池
		DriverManagerDataSource datasource =new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring4_day03");
		datasource.setUsername("root");
		datasource.setPassword("root");
		//创建jdbc模板
		JdbcTemplate jdbcTemplate =new JdbcTemplate(datasource);
		jdbcTemplate.update("insert into account values(null,?,?)","马户",10000d);
				
	}
}















































































