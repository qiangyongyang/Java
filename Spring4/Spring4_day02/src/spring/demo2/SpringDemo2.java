package spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
	
	@Test
	public void demo1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService service=(CustomerService) ac.getBean("customerService");
		service.save();
		
	}
}














































































