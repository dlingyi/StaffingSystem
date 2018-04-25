package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/db_staffingsystem?useUnicode=true&amp;characterEncoding=utf8";
	private static String user = "root";
	private static String password = "";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败" + e);
		}
	}

	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException("获得连接失败", e);
		}
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
