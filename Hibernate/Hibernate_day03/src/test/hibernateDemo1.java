package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

import Bean1.Customer;
import Bean1.LinkMan;
import utils.HibernateUtils;

/*
 * 一对多的测试类
 */
public class hibernateDemo1 {
	@Test
	//保存两个客户和三个联系人
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//创建两个客户
		Customer customer1 =new Customer();
		customer1.setCust_name("王朝");
		Customer customer2=new Customer();
		customer2.setCust_name("赵虎");
		
		//创建三个联系人
		LinkMan linkMan1=new LinkMan();
		linkMan1.setLkm_name("小学生1");
		LinkMan linkMan2=new LinkMan();
		linkMan2.setLkm_name("小学生2");
		LinkMan linkMan3=new LinkMan();
		linkMan3.setLkm_name("小学生3");
		
		//设置关系
		linkMan1.setCustomer(customer1);
		linkMan2.setCustomer(customer1);
		linkMan3.setCustomer(customer2);
		customer1.getLinkMans().add(linkMan1);
		customer1.getLinkMans().add(linkMan2);
		customer2.getLinkMans().add(linkMan3);
		
		//保存数据：
		session.save(linkMan1);
		session.save(linkMan2);
		session.save(linkMan3);
		session.save(customer1);
		session.save(customer2);
		
		tx.commit();
		
	}
	
	@Test
	//级联保存或更新
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer1 =new Customer();
		customer1.setCust_name("王朝");
		
		LinkMan linkMan1=new LinkMan();
		linkMan1.setLkm_name("小学生1");
		
		linkMan1.setCustomer(customer1);
	
		session.save(customer1);
		//session.save(linkMan1);
		tx.commit();
	}
	@Test
	//对象导航
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Customer customer1 =new Customer();
		customer1.setCust_name("王朝");
		
		
		LinkMan linkMan1=new LinkMan();
		linkMan1.setLkm_name("小学生1");
		LinkMan linkMan2=new LinkMan();
		linkMan2.setLkm_name("小学生2");
		LinkMan linkMan3=new LinkMan();
		linkMan3.setLkm_name("小学生3");
		
		//设置关系
		linkMan1.setCustomer(customer1);
		customer1.getLinkMans().add(linkMan2);
		customer1.getLinkMans().add(linkMan3);

		
		//保存数据：
		//session.save(linkMan1);//发送4条insert数据
		//session.save(customer1);//发送3条insert数据
		session.save(linkMan2);  //发送1条insert数据
		tx.commit();
	}
	
	@Test
	/*
	 * 2号联系人原来归5号客户，现在修改为6号客户
	 */
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//查询2号联系人
		LinkMan linkMan2 = session.get(LinkMan.class, 2l);
		
		//查询6号客户
		Customer customer2 = session.get(Customer.class, 6l);
		
		linkMan2.setCustomer(customer2);
		customer2.getLinkMans().add(linkMan2);
		tx.commit();
	}
	
}





















































































































