package com.itarena.category.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itarena.category.javabean.Book;
import com.itarena.category.javabean.Cart;
import com.itarena.category.javabean.CartItem;

public class CartServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Cart cart = new Cart();
	
	/**
	 * 购买书
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String shopBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartItem cartItem = new CartItem();
		cartItem.setCount(Integer.parseInt(req.getParameter("count")));
		Book book = new Book();
		book.setBid(req.getParameter("bid"));
		book.setImage(req.getParameter("image"));
		book.setBname(req.getParameter("bname"));
		book.setAuthor(req.getParameter("author"));
		book.setPrice(Double.valueOf(req.getParameter("price")));
		cartItem.setBook(book);
		cart.cartMap.put(req.getParameter("bid"), cartItem);
		double total =  alltotal(cart.cartMap);
		session.setAttribute("cart", cart.cartMap);
		session.setAttribute("total", total);
		return "jsps/cart/list.jsp";
	}

	/**
	 * 返回购物车中的总价格
	 * @param cartMap
	 * @return
	 */
	private double alltotal(Map<String, CartItem> cartMap) {
		double total = 0;
		Collection<CartItem> values = cartMap.values();
		for (Iterator<CartItem> it = values.iterator(); it.hasNext();) {
			CartItem cartItem = (CartItem) it.next();
			total += cartItem.subtotal();
		}
		BigDecimal b = new BigDecimal(total); 
		total = b.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
		return total;
	}
	
	/**
	 * 删除购物车中指定的图书
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		cart.cartMap.remove(req.getParameter("id"));
		double total =  alltotal(cart.cartMap);
		session.setAttribute("cart", cart.cartMap);
		session.setAttribute("total", total);
		return "jsps/cart/list.jsp";
	}
	
	/**
	 * 清空购物车
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		cart.cartMap.clear();
		session.setAttribute("cart", cart.cartMap);
		session.setAttribute("total", "");
		return "jsps/cart/list.jsp";
	}
	
	/**
	 * 我的购物车
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		double total =  alltotal(cart.cartMap);
		session.setAttribute("cart", cart.cartMap);
		session.setAttribute("total", total);
		return "jsps/cart/list.jsp";
	}
	
}
