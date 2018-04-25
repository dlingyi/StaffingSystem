package com.util;

import java.sql.Connection;
import org.junit.Test;

public class DBConnectionTest {

	@Test
	public void testGetConnection() {
		System.out.println(DBConnection.getConnection());
		Connection c = DBConnection.getConnection();
		DBConnection.close(c);
	}

}
