package test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import Pojo.User;
import utils.SqlSessionFactoryUtils;

public class MybatisTest {
	@Test
	public void getUserById() throws Exception{
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		User user = sqlSession.selectOne("user.getUserById",1);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void getUserByName() throws Exception{
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		List<User>list = sqlSession.selectList("user.getUserByName", "张");
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}
	
	@Test
	public void insert(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		User user=new User();
		user.setUsername("许褚");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("南京");
		sqlSession.insert("user.insertUser",user);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void delete(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		User user=new User();
		user.setId(16);
		sqlSession.delete("user.deleteUser", user);
		sqlSession.close();
	}
	
	@Test
	public void update(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		User user=new User();
		user.setId(30);
		user.setUsername("关羽");
		sqlSession.update("user.updateUser", user);
		sqlSession.close();
	}
	
}




































































































