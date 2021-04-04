
package com.vcs.admin.user.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.user.model.User;

public interface UserDao {
	int userInsert(Connection con, User user) throws SQLException;

	int userUpdate(Connection con, User user) throws SQLException;

	int userDelete(Connection con, User user) throws SQLException;

	List<User> userSelect(Connection con, User user) throws SQLException;
}
