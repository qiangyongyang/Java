package SpringDemo2;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 集合类型的属性注入
 */
public class SpringDemo2 {
	@Test
	public void demo1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionBean collectionBean=(CollectionBean) ac.getBean("collectionBean");
		System.out.println(collectionBean);
	}
	
	
}
