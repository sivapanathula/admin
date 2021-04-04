package com.vcs.admin.role.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.vcs.admin.base.dao.BaseDao;
import com.vcs.admin.common.adminconstant.AdminConstant;
import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.role.dao.RoleDao;
import com.vcs.admin.role.model.Roles;

public class RoleDaoImpl extends BaseDao implements RoleDao {
	private static ILogger logger = Log4jUtil.getLogger(RoleDaoImpl.class);

	public int roleInsert(Connection con, Roles role) throws SQLException {
		logger.info("RoleDaoImpl roleInsert method");
		int result = 0;
		try {
			List data = new ArrayList();
			logger.debug("RoleDaoImpl Data Object");
			data.add(role.getRoleId());
			data.add(role.getRoleName());

			result = (Integer) execute(con, AdminConstant.ROLE_INSERT, data);
		} catch (Exception e) {
			logger.debug("problem in RoleInsertDao : " + e);
		}
		logger.debug("RoleDaoImpl result");
		return result;
	}

	public int roleUpdate(Connection con, Roles role) throws SQLException {
		List data = new ArrayList();
		logger.debug("RoleDaoImpl Data Object");
		data.add(role.getRoleName());
		data.add(role.getRoleId());
		int result = (Integer) execute(con, AdminConstant.ROLE_UPDATE, data);
		logger.debug("RoleDaoImpl result");
		return result;
	}

	public int roleDelete(Connection con, Roles role) throws SQLException {
		int result = 0;
		List data = new ArrayList();
		logger.debug("RoleDaoImpl Data Object");
		data.add(role.getRoleId());
		result = (Integer) execute(con, AdminConstant.ROLE_DELETE, data);
		logger.debug("RoleDaoImpl result");
		return result;
	}

	public List roleSelect(Connection con, Roles role) throws SQLException {
		logger.info("RoleDaoImpl roleSelect Method");
		List result = null;
		List data = new ArrayList();
		logger.debug("RoleDaoImpl data Object ::" + data);
		StringBuilder sql = new StringBuilder(AdminConstant.ROLE_SELECT);
		logger.debug("RoleDaoImpl sql :: " + sql);
		List whereConditions = new ArrayList();
		logger.info("RoleDaoImpl whereCondition");
		if (role.getRoleId() != 0) {
			whereConditions.add("ROLE_ID=?");
			data.add(role.getRoleId());
		}
		if (StringUtils.isNotEmpty(role.getRoleName())) {
			whereConditions.add("ROLE_NAME=?");
			data.add(role.getRoleName());
		}
		if (!whereConditions.isEmpty()) {
			sql.append("where");
			for (int i = 0; i < whereConditions.size(); i++) {
				sql.append(whereConditions.get(i));
				if ((i + 1) != whereConditions.size()) {
					sql.append("and");
				}
			}
		}
		result = (List) execute(con, sql.toString(), data);
		logger.debug("RoleDaoImpl result :: " + result);
		return result;
	}

	protected List<Roles> processResultSet(ResultSet resultSet) {

		List<Roles> roleList = new ArrayList<Roles>();
		try {
			while (resultSet.next()) {
				Roles role = new Roles();
				role.setRoleId(resultSet.getInt(1));
				role.setRoleName(resultSet.getString(2));
				roleList.add(role);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return roleList;
	}
}
