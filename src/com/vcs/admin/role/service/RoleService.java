package com.vcs.admin.role.service;

import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.role.model.Roles;

public interface RoleService {
	int roleInsert(Roles role) throws SQLException;

	int roleUpdate(Roles role) throws SQLException;

	int roleDelete(Roles role) throws SQLException;

	List roleSelect(Roles role) throws SQLException;

}
