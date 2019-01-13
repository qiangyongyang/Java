package spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * 添加注解
 */
@Component("userDao333")  //相当于<bean id="userDao" class="spring.demo1.UserDaoImpl"/>
public class UserDaoImpl implements UserDao{
	@Value("李兵")
	private String name;
	
	@Override
	public void save() {
		System.out.println("dao中保存用户的方法执行了。。。。。。。"+name);
	}

}













































