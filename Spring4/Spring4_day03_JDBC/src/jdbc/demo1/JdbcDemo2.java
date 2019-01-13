package jdbc.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdbc.Bean.Account;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcDemo2 {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Test
	//插入
	public void demo1(){
		jdbcTemplate.update("insert into account values(null,?,?)","郝雯",8000d);
	}
	
	@Test
	//修改
	public void demo2(){
		jdbcTemplate.update("update account set name=? ,money=? where id=?","李鹏",10000,3);
	}
	
	@Test
	//删除
	public void demo3(){
		jdbcTemplate.update("delete from account where id=?",5);
	}
	
	@Test
	//查询：某个属性
	public void demo4(){
		String name=jdbcTemplate.queryForObject("select name from account where id=?",String.class,2);
		System.out.println(name);
	}
	
	@Test
	//查询总数
	public void demo5(){
		Long count=jdbcTemplate.queryForObject("select count(*)from account", Long.class);
		System.out.println("数据库里一共有"+count+"人");
	}
	
	
	@Test
	//封装到对象中
	public void demo6(){
		Account account=jdbcTemplate.queryForObject("select *from account where id=?", new MyRowMapper(), 1);
		System.out.println(account);
	}
	class MyRowMapper implements RowMapper<Account>{
		@Override
		public Account mapRow(ResultSet rs, int row) throws SQLException {
			Account account=new Account();
			account.setId(rs.getInt("id"));
			account.setName(rs.getString("name"));
			account.setMoney(rs.getDouble("money"));
			return account;
		}
	}
	
	
	@Test
	public void demo7(){
		List<Account> list=jdbcTemplate.query("select *from account ", new MyRowMapper());
		for (Account account : list) {
			System.out.println(account);
		}
	}
	
	
	
	
	
	
} 



























































































