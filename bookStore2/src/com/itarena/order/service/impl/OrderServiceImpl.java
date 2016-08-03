package com.itarena.order.service.impl;

import java.util.List;

import com.itarena.order.dao.OrderDao;
import com.itarena.order.dao.impl.OrderDaoImpl;
import com.itarena.order.javabean.Order;
import com.itarena.order.javabean.OrderItem;
import com.itarena.order.service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao orderDao = new OrderDaoImpl();
	
	/**
	 * 添加订单
	 */
	@Override
	public void add(Order order) {
		List<OrderItem> orderItems = order.getOrderItems();
		orderDao.addOrder(order);
		orderDao.addOrderItem(order, orderItems);
	}

	/**
	 * 查询所有订单事务
	 */
	@Override
	public List<Order> allOrder(String id) {
		List<Order> orders = orderDao.allOrder(id);
		return orders;
	}

	/**
	 * 付款事务处理实现
	 */
	@Override
	public Order findOrderById(String id) {
		Order order = orderDao.findOrderById(id);
		return order;
	}

}
