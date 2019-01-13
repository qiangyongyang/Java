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

//DBUtils ֻ�Ǽ���CRUD���룬���Ǵ��������Լ���ȡ���������ڿ��Ƿ�Χ

public class testDbUtils {
	
	@Test
	public void testInsert() throws SQLException{
	
		ComboPooledDataSource datasource=new ComboPooledDataSource();
		QueryRunner qr=new QueryRunner(datasource);
		
		//����
		//qr.update("insert into account values(null,?,?)", "a",100);
		
		//ɾ��
		//qr.update("delete from account where id=?",16);
		
		//����
		//qr.update("update account set money=? where  id=?", 10000,5);
		
		//ȥ��ѯ����ѯ��������result����������handle����
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
		
		//���淽���ļ򻯰�-----------��ѯ��������
		/*Account account=qr.query("select *from account where id=?", 
				new BeanHandler<Account>(Account.class), 5);
		System.out.println(account.toString());*/
		
	
		
		//--------------��ѯ�������--------------------------//
		
		List<Account> list=qr.query("select *from account", 
				new BeanListHandler<Account>(Account.class));
		for (Account account2 : list) {
			System.out.println(account2.toString());
		}
		
		
		
		
		
		
		
		/*
		 //������ӣ�ɾ�����޸�
		 * qr.update(sql);
		 * 
		 //��Բ�ѯ
		 * 
		 * qr.query(sql,rsh);
		 */
	}
}

























