package com.itarena.order.javabean;

import com.itarena.category.javabean.Book;

/**
 * 订单条目类
 * @author UIDragon
 *
 */
public class OrderItem {

	private String iid;
	private Book book;
	private int count;
	private double subtotal;
	private Order order;
	
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [iid=" + iid + ", book=" + book + ", count=" + count + ", subtotal=" + subtotal + ", order="
				+ order + "]";
	}
	
}
