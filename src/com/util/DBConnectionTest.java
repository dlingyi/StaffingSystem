package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class DBConnectionTest {

	@Test
	public void testGetConnection() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "select * from department where id in ? ";
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(0, "1,2");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("id") + "------------" + rs.getString("deptname"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBConnection.close(conn);
	}

}
