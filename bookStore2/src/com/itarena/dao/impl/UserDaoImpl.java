package com.itarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.itarena.dao.UserDao;
import com.itarena.javabean.User;
import com.itarena.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	Connection con = null;
	
	/**
	 * 注册时判断用户名是否存在
	 */
	@Override
	public User findUserByUname(String uname) {
		con = JdbcUtil.getConnection();
		String sql = "select * from bs_user where uname = ?";
		try {
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, uname);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUid(rs.getString("uid"));
				user.setUsername(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				System.out.println(user);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
		return null;
	}

	/**
	 * 注册用户：向数据库中添加用户
	 */
	@Override
	public void addUser(User user) {
		boolean addResult;
		con = JdbcUtil.getConnection();
		String sql = "insert into bs_user value (?, ?, ?)";
		PreparedStatement pStatement;
		try {
			pStatement = con.prepareStatement(sql);
			
			//UUID.randomUUID().toString() 随机自动生成 ID,且不重复:生成的是32位数字
			
			pStatement.setString(1, UUID.randomUUID().toString().substring(0, 4));
			pStatement.setString(2, user.getUsername());
			pStatement.setString(3, user.getPassword());
			pStatement.executeUpdate();
			addResult = true;
			if (addResult) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.getClose();
		}
	}

}
