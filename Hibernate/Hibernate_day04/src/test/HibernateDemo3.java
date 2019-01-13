package test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Bean1.Customer;
import utils.HibernateUtils;

/*
 * SQL查询
 */
public class HibernateDemo3 {
	
	@Test
	public void easyQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/*SQLQuery sqlQuery = session.createSQLQuery("select *from cst_customer");
		List<Object []> list = sqlQuery.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}*/
		
		SQLQuery sqlQuery = session.createSQLQuery("select *from cst_customer");
		sqlQuery.addEntity(Customer.class);
		List<Customer> list = sqlQuery.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
	}
}
