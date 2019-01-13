package hibernate01;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import utils.HibernateUtils;

/*
 * 入门
 */
public class HbnDemo01 {
	/*@Test
	public void demo01(){
		//1.加载hibernate核心配置文件
		Configuration configuration=new Configuration().configure();
		
		//2.创建一个SessionFactory对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//3.通过SessionFactory获取到Session对象，类似于JDBC的Connection
		Session session = sessionFactory.openSession();
		
		//4.手动开启事务
		Transaction transaction = session.beginTransaction();
		
		//5.编写代码
		Customer customer=new Customer();
		customer.setCust_name("ktPawn");
		
		session.save(customer);
		
		//6.提交事务
		transaction.commit();
		
		//7.资源释放
		session.close();
	}
	*/
	@Test
	public void demo02(){
		Session session = HibernateUtils.openSession();
		Transaction tx=session.beginTransaction();
		
		Customer customer =new Customer();
		customer.setCust_name("陆小凤");
		session.save(customer);
		
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void query(){
		Session session = HibernateUtils.openSession();
		Transaction tx=session.beginTransaction();
		
		/*
		 * 使用get方法查询
		 * 1.采用的立即加载，执行到这行代码时，会马上发送SQL语句查询
		 * 2.查询后返回的是真实对象本身
		 * 3.查询不到对象时，返回null
		 */
		
		/*Customer customer = session.get(Customer.class, 1l);
		System.out.println(customer);*/
		
		/*
		 * 使用load方法查询
		 * 1.采用延时加载（懒加载），执行到这行代码时，不发送SQL语句。当真正用到对象时，才会发送SQL语句。
		 * 2.查询后返回的的是代理对象
		 * 3.查询不到对象时，返回ObjectNotFoundException
		 */
		Customer customer = session.load(Customer.class, 4l);
		System.out.println(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void update(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 2l);
		customer.setCust_source("古龙");
		session.update(customer);
		
		tx.commit();
		session.close();
	}
	 
	@Test
	public void delete(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 3l);
		session.delete(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void  insert(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer=new Customer();
		customer.setCust_name("西门吹雪");
		session.saveOrUpdate(customer);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void findAll(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//接受HQL：面向对象查询语言
		/*Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
		}*/
		
		//接受SQL：
		SQLQuery query = session.createSQLQuery("select *from cst_customer");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		
		
		tx.commit();
		session.close();
	}

}




























