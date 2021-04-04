package com.vcs.admin.permission.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.permission.model.Permission;

public interface PermissionDao {
	int permissionInsert(Connection con, Permission permission) throws SQLException;

	int permissionUpdate(Connection con, Permission permission) throws SQLException;

	int permissionDelete(Connection con, Permission permission) throws SQLException;

	List permissionSelect(Connection con, Permission permission) throws SQLException;

}
