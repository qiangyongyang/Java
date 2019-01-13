package spring.demo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService{
	
	//注入Dao
	
	@Resource(name="userDao333")
	private UserDao dao;
	
	@Override
	public void save() {
		System.out.println("service执行了");
		dao.save();
	}

}
