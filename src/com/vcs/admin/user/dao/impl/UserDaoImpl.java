package com.vcs.admin.user.dao.impl;

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
import com.vcs.admin.user.controller.UserController;
import com.vcs.admin.user.dao.UserDao;
import com.vcs.admin.user.model.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	private static ILogger logger = Log4jUtil.getLogger(UserController.class);

	public int userInsert(Connection con, User user) throws SQLException {

		List<String> data = new ArrayList<String>();

		data.add(user.getFirstName());
		data.add(user.getLastName());
		data.add(user.getEmailId());
		data.add(user.getMobileNumber());
		data.add(user.getPassword());
		data.add(user.getDateOfBirth());
		data.add(user.getGender());

		int result = (Integer) execute(con, AdminConstant.USER_INSERT, data);
		return result;
	}

	public int userUpdate(Connection con, User user) throws SQLException {
		System.out.println("calling insert");
		List<String> data = new ArrayList<String>();
		data.add(user.getFirstName());
		data.add(user.getLastName());
		data.add(user.getMobileNumber());
		data.add(user.getPassword());
		data.add(user.getDateOfBirth());
		data.add(user.getGender());
		data.add(user.getEmailId());
		int result = (Integer) execute(con, AdminConstant.USER_UPDATE, data);
		return result;
	}

	public int userDelete(Connection con, User user) throws SQLException {
		List<String> data = new ArrayList<String>();
		data.add(user.getEmailId());
		int result = (Integer) execute(con, AdminConstant.USER_DELETE, data);

		return result;
	}

	public List<User> userSelect(Connection con, User user) throws SQLException {
		logger.debug("userSelect method");
		List<User> result = null;
		List<String> data = new ArrayList<String>();
		logger.debug("Data Object ");
		StringBuilder sql = new StringBuilder(AdminConstant.USER_SELECT);
		logger.info("sql query " + sql);
		List<String> whereConditions = new ArrayList<String>();
		logger.info("where condition Object " + whereConditions);

		if (StringUtils.isNotEmpty(user.getFirstName())) {
			whereConditions.add("FIRST_NAME=?");
			data.add(user.getFirstName());
		}
		if (StringUtils.isNotEmpty(user.getLastName())) {
			whereConditions.add("LAST_NAME=?");
			data.add(user.getLastName());
		}
		if (StringUtils.isNotEmpty(user.getEmailId())) {
			whereConditions.add("EMAIL_ID=?");
			data.add(user.getEmailId());
		}
		if (StringUtils.isNotEmpty(user.getMobileNumber())) {
			whereConditions.add("MOBILE_NUMBER=?");
			data.add(user.getMobileNumber());
		}
		if (StringUtils.isNotEmpty(user.getPassword())) {
			whereConditions.add("PASSWORD=?");
			data.add(user.getPassword());
		}
		if (StringUtils.isNotEmpty(user.getDateOfBirth())) {
			whereConditions.add("DATE_OF_BIRTH=?");
			data.add(user.getDateOfBirth());
		}
		if (StringUtils.isNotEmpty(user.getGender())) {
			whereConditions.add("GENDER=?");
			data.add(user.getGender());
		}
		if (!whereConditions.isEmpty()) {
			sql.append(" where ");
			for (int i = 0; i < whereConditions.size(); i++) {
				sql.append(whereConditions.get(i));
				if ((i + 1) != whereConditions.size()) {
					sql.append(" and ");
				}
			}
		}
		result = (List) execute(con, sql.toString(), data);
		logger.info("userSelect method " + result);
		return result;

	}

	protected List<User> processResultSet(ResultSet resultSet)
			throws SQLException {

		List<User> list = new ArrayList<User>();
		while (resultSet.next()) {
			User user = new User();
			user.setFirstName(resultSet.getString(1));
			user.setLastName(resultSet.getString(2));
			user.setEmailId(resultSet.getString(3));
			user.setMobileNumber(resultSet.getString(4));
			user.setPassword(resultSet.getString(5));
			user.setDateOfBirth(resultSet.getString(6));
			user.setGender(resultSet.getString(7));
			list.add(user);
		}

		return list;

	}

}
