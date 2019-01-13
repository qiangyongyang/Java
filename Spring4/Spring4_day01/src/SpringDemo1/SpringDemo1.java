package SpringDemo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 属性注入的方式：
 */
public class SpringDemo1 {
	@Test
	/*
	 * 构造方法的属性注入
	 */
	public void demo1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Car1 car=(Car1) ac.getBean("car1");
		System.out.println(car);
	}
	
	@Test
	/*
	 * set方法的属性注入
	 */
	public void demo2(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 car=(Car2) ac.getBean("car2");
		System.out.println(car);
	}
	
	
	@Test
	/*
	 * set方法来注入对象的类型
	 */
	public void demo3(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee= (Employee) ac.getBean("employee");
		System.out.println(employee);
	}
}


















































