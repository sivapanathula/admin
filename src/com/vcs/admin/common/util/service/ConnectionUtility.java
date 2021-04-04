package com.vcs.admin.common.util.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtility {
	private ConnectionUtility() {

	}

	public static final Connection createConnection() {

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("Connection problem " + e);
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (SQLException e) {
			System.out.println(e);
		}

		return con;

	}
}
