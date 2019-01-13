package spring_IOC;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
/*
 * 
 */
public class Springdemo1 {
	@Test
	/*
	 * 传统方式的调用
	 */
	public void demo1(){
		UserService service=new UserServiceImpl();
		service.save();
	}
	
	
	
	@Test
	/*
	 * Spring4方式的调用
	 */
	public void demo2(){
		//创建Spring工厂
								  //1.加载类路径下的配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
		UserService service=(UserService) ac.getBean("userService");
		service.save();
	}
}















































