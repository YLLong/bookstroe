package com.itarena.category.dao;

import java.util.ArrayList;

import com.itarena.category.javabean.Category;

public interface CategoryDao {

	ArrayList<Category> findAll();
	Category findCategoryById(String id);

}
