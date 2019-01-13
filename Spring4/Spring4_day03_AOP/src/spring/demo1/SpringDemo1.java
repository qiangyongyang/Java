package spring.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Spring的AOP的注解开发
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1 {
	@Resource(name="orderDao")
	private OrderDao dao;
	
	@Test
	public void demo1(){
		dao.save();
		System.out.println();
		dao.delete();
		System.out.println();
		dao.update();
		System.out.println();
		dao.find();
	}
}
