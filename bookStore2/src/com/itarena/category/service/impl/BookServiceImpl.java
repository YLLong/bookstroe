package com.itarena.category.service.impl;

import java.util.ArrayList;

import com.itarena.category.dao.BookDao;
import com.itarena.category.dao.impl.BookDaoImpl;
import com.itarena.category.javabean.Book;
import com.itarena.category.service.BookService;

public class BookServiceImpl implements BookService {

	BookDao bookDao = new BookDaoImpl();
	
	/**
	 * 查找所有图书
	 */
	@Override
	public ArrayList<Book> findAll() {
		ArrayList<Book> allBooks = bookDao.findAll();
		return allBooks;
	}

	/**
	 * 根据传入的类别id，查询该类别所有图书
	 */
	@Override
	public ArrayList<Book> findBooksById(String id) {
		ArrayList<Book> books = bookDao.findBooksById(id);
		return books;
	}

	/**
	 * 根据图书id显示图书信息
	 */
	@Override
	public Book findBookInfoById(String id) {
		Book book = bookDao.findBookInfoById(id);
		return book;
	}

}
