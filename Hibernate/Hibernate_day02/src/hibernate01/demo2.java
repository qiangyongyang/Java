package hibernate01;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtils;

/*
 * Hibernate的持久化类的三种状态：
 */
public class demo2 {
	@Test
	public void text(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer=new Customer();//瞬时态对象，没有唯一标识OID，没有被session管理
		customer.setCust_name("score");
		
		Serializable id = session.save(customer);//持久态对象，有唯一标识OID，被session管理
		
		session.get(Customer.class, id);
		
		tx.commit();
		session.close();
		
		System.out.println(customer.getCust_name());//托管态，有唯一OID，没有被session管理
	}
}
