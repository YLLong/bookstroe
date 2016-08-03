package com.itarena.category.dao;

import java.util.ArrayList;

import com.itarena.category.javabean.Book;

public interface BookDao {

	//查找所有图书
	ArrayList<Book> findAll();
	//根据分类id查询当前类的图书
	ArrayList<Book> findBooksById(String id);
	//根据图书id查询图书信息
	Book findBookInfoById(String id);
	
}
