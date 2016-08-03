package com.itarena.category.javabean;

/**
 * 购物车条目
 * @author UIDragon
 *
 */
public class CartItem {

	private Book book;
	private int count;
	
	/**
	 * 小计：此书的价格 * 此书数量
	 * @return
	 */
	public double subtotal() {
		return book.getPrice() * count;
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
	
}
