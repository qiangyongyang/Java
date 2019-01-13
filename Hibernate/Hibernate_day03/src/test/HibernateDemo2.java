package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Bean2.Role;
import Bean2.User;
import utils.HibernateUtils;

/*
 * 多对多的测试类
 */
public class HibernateDemo2 {
	
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//创建2个用户
		User user1=new User();
		user1.setUser_name("任怡旭");
		User user2=new User();
		user2.setUser_name("美人阴");
		
		//创建3个角色
		Role role1=new Role();
		role1.setRole_name("红眼");
		Role role2=new Role();
		role2.setRole_name("白手");
		Role role3=new Role();
		role3.setRole_name("瞎子");
		
		//设置双向关联关系:
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user2);
		
		//保存数据:多对多建立双向的关系，被动方放弃外键维护权
		//设置inverse为true
		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		session.save(role3);
		
		tx.commit();
	}
	
	@Test
	/*
	 * 给用户增加角色
	 */
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1l);
		Role role = session.get(Role.class, 31);
		user.getRoles().add(role);
		
		tx.commit();
	}
	@Test
	/*
	 * 给用户修改角色
	 */
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 2l);
		Role role1 = session.get(Role.class, 11);
		Role role2 = session.get(Role.class, 21);
		user.getRoles().remove(role2);
		user.getRoles().add(role1);
		
		tx.commit();
	}
}































































































