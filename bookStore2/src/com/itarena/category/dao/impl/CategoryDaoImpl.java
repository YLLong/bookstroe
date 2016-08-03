package com.itarena.category.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itarena.category.dao.CategoryDao;
import com.itarena.category.javabean.Category;
import com.itarena.util.JdbcUtil;

public class CategoryDaoImpl implements CategoryDao {

	/*
	 * 返回所有的分类集合
	 * (non-Javadoc)
	 * @see com.itarena.category.dao.CategoryDao#findAll()
	 */
	@Override
	public ArrayList<Category> findAll() {
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_category";
		PreparedStatement pStatement;
		//不要 = null 这样返回会报空指针异常
		ArrayList<Category> cArrayList = new ArrayList<Category>();
		try {
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCid(rs.getString("cid"));
				category.setCname(rs.getString("cname"));
				cArrayList.add(category);
			}
			return cArrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return cArrayList;
	}

	/**
	 * 根据传入的分类id查找分类类别
	 */
	@Override
	public Category findCategoryById(String id) {
		Category category = new Category();
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_category where cid = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				category.setCid(rs.getString("cid"));
				category.setCname(rs.getString("cname"));
			}
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return category;
	}

}
