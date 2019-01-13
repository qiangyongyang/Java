package hibernate01;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtils;

/*
 * Hibernate的一级缓存的测试
 */
public class demo3 {
	@Test
	public void a(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 1l);//发送SQL语句
		System.out.println(customer);
		
		Customer customer2 = session.get(Customer.class, 1l);//不发送SQL语句
		System.out.println(customer2);
		
		System.out.println(customer==customer2);
		tx.commit(); 
		session.close();
	}
}














































































