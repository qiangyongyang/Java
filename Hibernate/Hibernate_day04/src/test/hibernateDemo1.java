package test;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import Bean1.Customer;
import Bean1.LinkMan;
import utils.HibernateUtils;

public class hibernateDemo1 {
	
	@Test
	/*
	 * HQL初始化数据
	 */
	public void init(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer=new Customer();
		customer.setCust_name("kt战队");
		
		for(int i=0;i<=10;i++){
			LinkMan linkMan=new LinkMan();
			linkMan.setLkm_name("mata"+i);
			linkMan.setCustomer(customer);
			
			customer.getLinkMans().add(linkMan);
			
			session.save(linkMan);
		}
		session.save(customer);
		tx.commit();
	}
	
	@Test
	/*
	 * HQL的简单查询
	 */
	public void easyQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	@Test
	/*
	 * HQL的排序查询
	 */
	public void sortQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer order by cust_id desc").list();
	
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
	}
	
	
	@Test
	/*
	 * HQL的按条件查询
	 */
	public void AttributeQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//1.按位置绑定
		/*Query query = session.createQuery("from Customer where cust_name=?");
		query.setParameter(0, "kt战队");
		List<Customer> list = query.list();*/
		
		//2.按名称绑定
		Query query = session.createQuery("from Customer where cust_source= :aaa and cust_name like :bbb");
		query.setParameter("aaa", "OGN");
		query.setParameter("bbb", "kt%");
		List<Customer> list = query.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
	}
	
	@Test
	/*
	 * HQL的投影查询：查询对象某个或者某些属性
	 */
	public void projectionQuery(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//1.按位置绑定
		/*Query query = session.createQuery("from Customer where cust_name=?");
		query.setParameter(0, "kt战队");
		List<Customer> list = query.list();*/
		
		//2.按名称绑定
		Query query = session.createQuery("from Customer where cust_source= :aaa and cust_name like :bbb");
		query.setParameter("aaa", "OGN");
		query.setParameter("bbb", "kt%");
		List<Customer> list = query.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
	}
	
    
	
	
	//------------------------------------------------------------------------------------------------------------
	@Test
	/*
	 * HQL的多表查询
	 */
	public void  multiTablesQurty(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//SQL显示内连接: select *from cst_customer c inner join cst_linkman l on c.cust_id=l.lkm_cust_id;
		//HQL显示内连接: from Customer c inner join c.linkMans;
		/*List<Object[]> list = session.createQuery("from Customer c inner join c.linkMans").list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}*/
		
		
		//HQL的迫切内链接：在普通的内链接inner join 后添加关键字fecth:from Customer c inner join fetch c.linkMans
		List<Customer> list = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
	}
}



































































