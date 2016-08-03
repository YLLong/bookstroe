package com.itarena.category.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itarena.category.javabean.Book;
import com.itarena.category.service.BookService;
import com.itarena.category.service.CategoryService;
import com.itarena.category.service.impl.BookServiceImpl;
import com.itarena.category.service.impl.CategoryServiceImpl;

public class BookServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CategoryService categoryService = new CategoryServiceImpl();
	BookService bookService = new BookServiceImpl();
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Book> allBooks = bookService.findAll();
		req.setAttribute("books", allBooks);
		return "jsps/book/list.jsp";
	}
	
	public String findBooksById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ArrayList<Book> books = bookService.findBooksById(id);
		req.setAttribute("books", books);
		return "jsps/book/list.jsp";
	}
	
	/**
	 * 根据 书id 查找图书信息
	 * @param id
	 * @return
	 */
	public String findBookInfoById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Book book = bookService.findBookInfoById(id);
		req.setAttribute("book", book);
		return "jsps/book/desc.jsp";
	}

}
