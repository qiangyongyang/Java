package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Pojo.QueryVo;
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
	
	
	
	
	
	
	/*----------------第二天-----------------------*/
	@Test
	public void testGetUserByQueryVo() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo vo=new QueryVo();
		User user=new User();
		user.setUsername("张");
		vo.setUser(user);
		
		List<User> list = userMapper.getUserByQueryVo(vo);
		for (User user2 : list) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
	
	
	@Test
	public void testGetUserCount() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
		Integer userCount = userMapper.getUserCount();
		System.out.println("用户总记录数为："+userCount);
		sqlSession.close();
	}
	
	/*
	 * if标签的使用
	 */
	@Test
	public void testGetUserPojo() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setSex("1");
		user.setUsername("");
		List<User> list = userMapper.getUserByPojo(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
	
	/*
	 * where标签的使用
	 */
	@Test
	public void testGetUserPojo_where() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setSex("1");
		user.setUsername("");
		List<User> list = userMapper.getUserByPojo(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
	
	@Test
	public void testGetUserByIds() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		QueryVo vo=new QueryVo();
		vo.setIds(Arrays.asList(1,28,29,30,31));
		List<User> list = userMapper.getUserByIds(vo);
		for (User user2 : list) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
	
	

}
