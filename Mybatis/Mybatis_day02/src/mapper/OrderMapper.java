package mapper;

import java.util.List;

import Pojo.Order;
import Pojo.OrderUser;

public interface OrderMapper {
	List<Order> getOrderList();
	
	/*
	 * resultMap的使用
	 */
	List<Order> getOrderListMap();
	
	List<OrderUser> getOrderUser();
	
	List<Order> getOrderUserMap();
}
