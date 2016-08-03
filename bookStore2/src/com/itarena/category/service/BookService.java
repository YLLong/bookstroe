package com.itarena.category.service;

import java.util.ArrayList;

import com.itarena.category.javabean.Book;

public interface BookService {

	//查找所有图书
	ArrayList<Book> findAll();
	//根据类别的id查找图书
	ArrayList<Book> findBooksById(String id);
	//根据id查找图书信息
	Book findBookInfoById(String id);
	
}
