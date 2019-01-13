 package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Pojo.User;
import mapper.UserMapper;
import utils.SqlSessionFactoryUtils;

public class UserMapperTest {

	@Test
	public void testGetUserById() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(30);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testGetUserByName() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.getUserByName("张");
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void testInsert() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setUsername("许褚");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("魏国");
		userMapper.insert(user);
		sqlSession.close();
		
	}

}
