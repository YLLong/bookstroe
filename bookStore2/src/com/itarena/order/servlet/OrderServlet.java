package com.itarena.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itarena.category.javabean.CartItem;
import com.itarena.category.servlet.BaseServlet;
import com.itarena.javabean.User;
import com.itarena.order.javabean.Order;
import com.itarena.order.javabean.OrderItem;
import com.itarena.order.service.OrderService;
import com.itarena.order.service.impl.OrderServiceImpl;

public class OrderServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrderService orderService = new OrderServiceImpl();
	
	/**
	 * 一键购买后的当前订单
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String currentOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Order order = new Order();
		order.setOid(UUID.randomUUID().toString().substring(0, 5));
		order.setOrdertime(new Date());
		order.setTotal((double) session.getAttribute("total"));
		order.setAddress("默认地址");
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		order.setUser(user);
		order.setState(1);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		@SuppressWarnings("unchecked")
		Map<String, CartItem> cartMap = (Map<String, CartItem>) session.getAttribute("cart");
		for (CartItem cartItem : cartMap.values()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setIid(UUID.randomUUID().toString().substring(0, 5));
			orderItem.setBook(cartItem.getBook());
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.subtotal());
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		session.setAttribute("order", order);
		orderService.add(order);
		cartMap.clear();
		return "jsps/order/desc.jsp";
	}
	
	/**
	 * 我的订单（从数据库中读取数据）
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		List<Order> orders = orderService.allOrder(user.getUid());
		System.out.println(orders);
		session.setAttribute("orders", orders);
		return "jsps/order/list.jsp";
	}
	
	/**
	 * 付款处理
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String playment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		Order order = orderService.findOrderById(id);
		session.setAttribute("order", order);
		return "jsps/order/desc.jsp";
	}
	
}
