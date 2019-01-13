package test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Pojo.Order;
import Pojo.OrderUser;
import mapper.OrderMapper;
import utils.SqlSessionFactoryUtils;

public class OrderMapperTest {

	@Test
	public void testGetOrderList() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = orderMapper.getOrderList();
		for (Order order : list) {
			System.out.println(order);
		}
		sqlSession.close();
	}
	
	
	@Test
	public void testGetOrderListMap() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = orderMapper.getOrderList();
		for (Order order : list) {
			System.out.println(order);
		}
		sqlSession.close();
	}
	
	
	@Test
	public void testGetOrderUser() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUser> list = orderMapper.getOrderUser();
		for (OrderUser orderUser : list) {
			System.out.println(orderUser);
		}
		sqlSession.close();
	}
	
	

	@Test
	public void testGetOrderUserMap() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = orderMapper.getOrderUserMap();
		for (Order order : list) {
			System.out.println(order);
		}
		sqlSession.close();
	}
	
}
