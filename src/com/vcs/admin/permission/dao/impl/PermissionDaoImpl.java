package com.vcs.admin.permission.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.vcs.admin.base.dao.BaseDao;
import com.vcs.admin.common.adminconstant.AdminConstant;
import com.vcs.admin.permission.dao.PermissionDao;
import com.vcs.admin.permission.model.Permission;

public class PermissionDaoImpl extends BaseDao implements PermissionDao {

	public int permissionInsert(Connection con, Permission permission) throws SQLException {
		System.out.println("calling insert");

		List data = new ArrayList();
		data.add(permission.getPermissionId());
		data.add(permission.getPermissionName());

		System.out.println("calling set method in dao");

		int result = (Integer) execute(con, AdminConstant.PERMISSION_INSERT, data);
		System.out.println("calling execute method in dao");
		return result;
	}

	public int permissionUpdate(Connection con, Permission permission) throws SQLException {
		System.out.println("calling permissionUpdate");
		List data = new ArrayList();
		data.add(permission.getPermissionName());
		data.add(permission.getPermissionId());

		System.out.println("calling set method in dao :"+data);

		int result = (Integer) execute(con, AdminConstant.PERMISSION_UPDATE, data);
		System.out.println("calling execute method in dao");
		return result;
	}

	public int permissionDelete(Connection con, Permission permission) throws SQLException {
		System.out.println("calling insert");
		List data = new ArrayList();
		data.add(permission.getPermissionId());
		System.out.println("calling set method in dao" + data);
		int result = (Integer) execute(con, AdminConstant.PERMISSION_DELETE, data);
		System.out.println("calling execute method in dao");

		return result;
	}

	public List permissionSelect(Connection con, Permission permission) throws SQLException {

		List result = null;

		List data = new ArrayList();

		StringBuilder sql = new StringBuilder(AdminConstant.PERMISSION_SELECT);

		List whereConditions = new ArrayList();

		if (StringUtils.isNotEmpty(permission.getPermissionId())) {
			whereConditions.add("PERMISSION_ID=?");
			data.add(permission.getPermissionId());
		}
		if (StringUtils.isNotEmpty(permission.getPermissionName())) {
			whereConditions.add("PERMISSION_NAME=?");
			data.add(permission.getPermissionName());
		}
		if (!whereConditions.isEmpty()) {
			sql.append(" where ");
			for (int i = 0; i < whereConditions.size(); i++){
				sql.append(whereConditions.get(i));
				if ((i + 1) != whereConditions.size()) {
					sql.append(" and ");
				}
			}
		}
		
		result = (List) execute(con, sql.toString(), data);
		System.out.println(" value   " + result);
		return result;
	}

	public List processResultSet(ResultSet resultSet) throws SQLException {

		List list = new ArrayList();
		while (resultSet.next()) {
			Permission permission = new Permission();
			permission.setPermissionId(resultSet.getString(1));
			permission.setPermissionName(resultSet.getString(2));

			list.add(permission);
		}

		return list;

	}

}

