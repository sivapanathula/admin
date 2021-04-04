package com.vcs.admin.base.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

	// create Statement
	private PreparedStatement createStatement(Connection con, String sql) throws SQLException {
		return con.prepareStatement(sql);
	}

	// Setting Data
	private void setData(PreparedStatement pstmt, List data) throws SQLException {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) instanceof String)
				pstmt.setString(i + 1, (String) data.get(i));
				if (data.get(i) instanceof Integer) 
					pstmt.setInt(i + 1, (Integer) data.get(i));

				}
			}
	// execute statement
	private int executeUpdate(PreparedStatement pstmt) throws SQLException {
		return pstmt.executeUpdate();
	}

	// process result close
	private void closeStatement(PreparedStatement pstmt) throws SQLException {
		pstmt.close();
	}

	// execute statement
	protected final Object execute(Connection con, String sql, List data) throws SQLException {
		PreparedStatement pstmt = createStatement(con, sql);
		setData(pstmt, data);
		Object result;
		if (sql.toLowerCase().contains("select")) {
			ResultSet resultSet = executeQuery(pstmt);
			result = processResultSet(resultSet);
		} else {
			result = executeUpdate(pstmt);
		}
		closeStatement(pstmt);
		return result;
	}

	private ResultSet executeQuery(PreparedStatement pstmt) throws SQLException {
		return pstmt.executeQuery();
	}

	protected List processResultSet(ResultSet resultSet) throws SQLException {
		return null;

	}
}
