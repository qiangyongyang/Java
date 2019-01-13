package DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//DBUtils 只是简化了CRUD代码，但是创建连接以及获取工作，不在考虑范围

public class testDbUtils {
	
	@Test
	public void testInsert() throws SQLException{
	
		ComboPooledDataSource datasource=new ComboPooledDataSource();
		QueryRunner qr=new QueryRunner(datasource);
		
		//增加
		//qr.update("insert into account values(null,?,?)", "a",100);
		
		//删除
		//qr.update("delete from account where id=?",16);
		
		//更新
		//qr.update("update account set money=? where  id=?", 10000,5);
		
		//去查询，查询的数据在result里，调用下面的handle方法
		/*Account account=qr.query("select *from account where id=?", new ResultSetHandler<Account>(){

			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account account=new Account();
				while(rs.next()){
					String name=rs.getString("name");
					int money=rs.getInt("money");
					
					account.setMoney(money);
					account.setName(name);
				}
				return account;
			}
			
		}, 5);
		System.out.println(account.toString());*/
		
		//上面方法的简化版-----------查询单个对像
		/*Account account=qr.query("select *from account where id=?", 
				new BeanHandler<Account>(Account.class), 5);
		System.out.println(account.toString());*/
		
	
		
		//--------------查询多个对象--------------------------//
		
		List<Account> list=qr.query("select *from account", 
				new BeanListHandler<Account>(Account.class));
		for (Account account2 : list) {
			System.out.println(account2.toString());
		}
		
		
		
		
		
		
		
		/*
		 //针对增加，删除，修改
		 * qr.update(sql);
		 * 
		 //针对查询
		 * 
		 * qr.query(sql,rsh);
		 */
	}
}

























