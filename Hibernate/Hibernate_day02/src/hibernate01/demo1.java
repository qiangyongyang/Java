package hibernate01;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtils;

/*
 * Hibernate主键生成策略
 */
public class demo1 {
	
	@Test
	public void save(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer=new Customer();
		customer.setCust_name("smeb");
		session.save(customer);
		
		tx.commit();
		session.close();
	}
}
