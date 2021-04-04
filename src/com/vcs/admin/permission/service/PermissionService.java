package com.vcs.admin.permission.service;

import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.permission.model.Permission;

public interface PermissionService {
	int permissionInsert(Permission permission) throws SQLException, ClassNotFoundException;

	int permissionUpdate(Permission permission) throws SQLException, ClassNotFoundException;

	int permissionDelete(Permission permission) throws SQLException, ClassNotFoundException;

	List permissionSelect(Permission permission) throws SQLException, ClassNotFoundException;

}
