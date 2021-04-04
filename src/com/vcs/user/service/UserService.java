package com.vcs.user.service;

import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.user.model.User;

public interface UserService {
	int userInsert(User user) throws SQLException, ClassNotFoundException;

	int userUpdate(User user) throws SQLException, ClassNotFoundException;

	int userDelete(User user) throws SQLException, ClassNotFoundException;

	List<User> userSelect(User user) throws SQLException, ClassNotFoundException;;
}
