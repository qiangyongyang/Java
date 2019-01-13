package spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
	@Test
	public void demo1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao) ac.getBean("userDao");
		dao.save();
	}
	
	
	@Test
	public void demo2(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service=(UserService) ac.getBean("userService");
		service.save();
	}
}


















































