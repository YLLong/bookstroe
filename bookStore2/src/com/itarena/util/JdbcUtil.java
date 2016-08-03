package com.itarena.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	static Connection connection = null;
	static String url = "jdbc:mysql:///bookstore";
	static String user = "root";
	static String password = "06dmysql";

	/*
	 * 连接数据库
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭数据库连接
	 */
	public static void getClose() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
