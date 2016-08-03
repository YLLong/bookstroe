package com.itarena.order.javabean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itarena.javabean.User;

/**
 * 订单类
 * @author UIDragon
 *
 */
public class Order {
	
	private String oid;
	private Date ordertime;
	private double total;
	private String address;
	private User user;
	private int state;
	
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", address=" + address
				+ ", user=" + user + ", state=" + state + ", orderItems=" + orderItems + "]";
	}
	
}
