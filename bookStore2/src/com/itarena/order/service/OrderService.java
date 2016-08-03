package com.itarena.order.service;

import java.util.List;

import com.itarena.order.javabean.Order;

public interface OrderService {
	
	/**
	 * 添加订单
	 * @param order
	 */
	void add(Order order);

	/**
	 * 查询当前用户所有订单事务
	 * @param id 
	 * @return
	 */
	List<Order> allOrder(String id);

	/**
	 * 付款事务处理
	 * @param id
	 * @return
	 */
	Order findOrderById(String id);

}
