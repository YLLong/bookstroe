package com.itarena.order.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itarena.category.dao.BookDao;
import com.itarena.category.dao.impl.BookDaoImpl;
import com.itarena.category.javabean.Book;
import com.itarena.order.dao.OrderDao;
import com.itarena.order.javabean.Order;
import com.itarena.order.javabean.OrderItem;
import com.itarena.util.JdbcUtil;

public class OrderDaoImpl implements OrderDao {

	/**
	 * 添加订单
	 */
	@Override
	public void addOrder(Order order) {
		Connection connection = JdbcUtil.getConnection();
		String sql = "insert into bs_order values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, order.getOid());
			pStatement.setDate(2, new Date(order.getOrdertime().getTime()));
			pStatement.setDouble(3, order.getTotal());
			pStatement.setString(4, order.getAddress());
			pStatement.setString(5, order.getUser().getUid());
			pStatement.setInt(6, order.getState());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
	}

	/**
	 * 添加订单条目
	 */
	@Override
	public void addOrderItem(Order order, List<OrderItem> orderItems) {
		Connection connection = JdbcUtil.getConnection();
		String sql = "insert into bs_orderItem values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			for (OrderItem orderItem : orderItems) {
				pStatement.setString(1, orderItem.getIid());
				pStatement.setString(2, orderItem.getBook().getBid());
				pStatement.setInt(3, orderItem.getCount());
				pStatement.setDouble(4, orderItem.getSubtotal());
				pStatement.setString(5, order.getOid());
				pStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
	}

	/**
	 * 查询所有的订单
	 */
	@Override
	public List<Order> allOrder(String id) {
		List<Order> orders = new ArrayList<Order>();
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_order where uid = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOid(rs.getString("oid"));
				order.setOrdertime(rs.getDate("ordertime"));
				order.setTotal(rs.getDouble("total"));
				order.setAddress(rs.getString("address"));
				List<OrderItem> orderItems = loadOrderItems(order);
				order.setOrderItems(orderItems);
				orders.add(order);
			}
		} catch (SQLException e) {
			JdbcUtil.getClose();
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return orders;
	}

	/**
	 * 查询订单条目
	 * @param order
	 * @return
	 */
	private List<OrderItem> loadOrderItems(Order order) {
		String id = order.getOid();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_orderItem where oid = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setIid(rs.getString("iid"));
				BookDao bookDao = new BookDaoImpl();
				Book book = bookDao.findBookInfoById(rs.getString("bid"));
				orderItem.setBook(book);
				orderItem.setCount(rs.getInt("count"));
				orderItem.setSubtotal(rs.getDouble("subtotal"));
				orderItems.add(orderItem);
			}
		} catch (SQLException e) {
			JdbcUtil.getClose();
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return orderItems;
	}

	/**
	 * 付款实现
	 */
	@Override
	public Order findOrderById(String id) {
		Order order = new Order();
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_order where oid = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				order.setOid(rs.getString("oid"));
				order.setOrdertime(rs.getDate("ordertime"));
				order.setTotal(rs.getDouble("total"));
				order.setAddress(rs.getString("address"));
				List<OrderItem> orderItems = loadOrderItems(order);
				order.setOrderItems(orderItems);
			}
		} catch (SQLException e) {
			JdbcUtil.getClose();
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return order;
	}

}
