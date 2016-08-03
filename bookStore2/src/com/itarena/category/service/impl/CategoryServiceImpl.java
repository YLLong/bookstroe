package com.itarena.category.service.impl;

import java.util.ArrayList;

import com.itarena.category.dao.BookDao;
import com.itarena.category.dao.CategoryDao;
import com.itarena.category.dao.impl.BookDaoImpl;
import com.itarena.category.dao.impl.CategoryDaoImpl;
import com.itarena.category.javabean.Category;
import com.itarena.category.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao = new CategoryDaoImpl();
	BookDao bookDao = new BookDaoImpl();
	
	/**
	 * 查询所有的分类
	 */
	@Override
	public ArrayList<Category> findAll() {
		ArrayList<Category> arrayList = categoryDao.findAll();
		return arrayList;
	}

}
