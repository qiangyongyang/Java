package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Pojo.User;
import dao.UserDao;
import utils.SqlSessionFactoryUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUserById(Integer id) {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		User user=sqlSession.selectOne("user.getUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByName(String username) {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		List<User> list = sqlSession.selectList("user.getUserByName", username);
		sqlSession.close();
		return list;
	}

	@Override
	public void insert(User user) {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession(true);
		sqlSession.insert("user.insertUser", user);
		sqlSession.close();
	}

}





























































