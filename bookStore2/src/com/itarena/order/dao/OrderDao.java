package com.itarena.order.dao;

import java.util.List;

import com.itarena.order.javabean.Order;
import com.itarena.order.javabean.OrderItem;

public interface OrderDao {

	/**
	 * 添加订单
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * 添加订单条目
	 * @param order 
	 * @param orderItems
	 */
	void addOrderItem(Order order, List<OrderItem> orderItems);

	/**
	 * 查询所有的订单
	 * @return
	 */
	List<Order> allOrder(String id);

	/**
	 * 付款得到该订单id,去查询订单详情并跳转到付款页面
	 * @param id
	 * @return
	 */
	Order findOrderById(String id);

}
