package test;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import Bean1.Customer;
import utils.HibernateUtils;

/*
 * QBC的查询
 */
public class hibernateDemo2 {
	@Test
	/*
	 * 简单查询
	 */
	public void easyQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//获得Criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	@Test
	/*
	 * 排序查询
	 */
	public void sortQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//获得Criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(Order.desc("cust_id")); //降序
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	
	
	@Test
	/*
	 * 统计查询
	 */
	public void StatisticalQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//获得Criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		/*
		 * add				:普通条件，where后面的条件
		 * addOrder			:排序
		 * setProjection	:聚合函数和 group by having
		 */
		criteria.setProjection(Projections.rowCount());
		Long sum=(Long)criteria.uniqueResult();
		System.out.println(sum);
		
		
		tx.commit();
	}
	
	
	@Test
	/*
	 * 条件查询
	 */
	public void AttributeQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//获得Criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		//设置条件
		/*
		 * ==	eq
		 * >	gt
		 * >=	ge
		 * <	lt
		 * <=	le
		 * !=	ne
		 */
		criteria.add(Restrictions.eq("cust_source", "OGN"));
		List<Customer> list = criteria.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	
	
	@Test
	/*
	 * 离线条件查询
	 */
	public void DetacheCriteriaQuery(){
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.like("cust_name", "%S%"));
		
		Session session=HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
}









































































































































































