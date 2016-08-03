package com.itarena.category.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itarena.category.dao.BookDao;
import com.itarena.category.dao.CategoryDao;
import com.itarena.category.javabean.Book;
import com.itarena.category.javabean.Category;
import com.itarena.util.JdbcUtil;

public class BookDaoImpl implements BookDao {

	CategoryDao categoryDao = new CategoryDaoImpl();
	Category category = new Category();
	ArrayList<Book> allBooks;
	Book book;
	
	/**
	 * 查询所有图书
	 */
	@Override
	public ArrayList<Book> findAll() {
		allBooks = new ArrayList<Book>();
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_book";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				category = categoryDao.findCategoryById(rs.getString("category_cid"));
				Book book = new Book();
				book.setBid(rs.getString("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setImage(rs.getString("image"));
				book.setCategory_cid(category);
				allBooks.add(book);
			}
			return allBooks;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return allBooks;
	}

	/**
	 * 根据传入的类别id，查询该类别的所有图书
	 */
	@Override
	public ArrayList<Book> findBooksById(String id) {
		allBooks = new ArrayList<Book>();
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_book where category_cid = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBid(rs.getString("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setImage(rs.getString("image"));
				book.setPrice(rs.getDouble("price"));
				allBooks.add(book);
			}
			return allBooks;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return allBooks;
	}

	/**
	 * 根据图书id查询图书信息
	 */
	@Override
	public Book findBookInfoById(String id) {
		book = new Book();
		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from bs_book where bid = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				book.setBid(rs.getString("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setImage(rs.getString("image"));
				book.setPrice(rs.getDouble("price"));
			}
			return book;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return book;
	}

}
