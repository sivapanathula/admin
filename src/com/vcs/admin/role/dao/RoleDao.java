package com.vcs.admin.role.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.role.model.Roles;

public interface RoleDao {
	
	int roleInsert(Connection con, Roles role) throws SQLException;

	int roleUpdate(Connection con, Roles role) throws SQLException;

	int roleDelete(Connection con, Roles role) throws SQLException;

	List roleSelect(Connection con, Roles role) throws SQLException;

}
