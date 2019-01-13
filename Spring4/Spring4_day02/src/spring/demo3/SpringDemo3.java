package spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {
	@Test
	public void demo1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService service=(ProductService) ac.getBean("productService");
		service.save();
	}
}






































































