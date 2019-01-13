package test;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import Pojo.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserDaoTest {
	UserDao userDao=new UserDaoImpl();
	
	@Test
	public void testGetUserById() {
		User user = userDao.getUserById(30);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {
		List<User> list = userDao.getUserByName("张飞");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsert() {
		User user=new User();
		user.setUsername("孟德");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("桃园");
		userDao.insert(user);
	}

}
