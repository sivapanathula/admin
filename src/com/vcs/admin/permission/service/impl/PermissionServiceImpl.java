package com.vcs.admin.permission.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.common.factory.DaoFactory;
import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.ConnectionUtility;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.permission.dao.PermissionDao;
import com.vcs.admin.permission.model.Permission;
import com.vcs.admin.permission.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	private static ILogger logger = Log4jUtil
			.getLogger(PermissionServiceImpl.class);

	public int permissionInsert(Permission permission) throws SQLException,
			ClassNotFoundException {
		logger.info("PermissionServiceImpl");
		int result = 0;
		Connection con = null;

		try {
			con = ConnectionUtility.createConnection();
			logger.debug("connection");
			con.setAutoCommit(false);
			logger.info("transaction strat");
			PermissionDao permissionDao = DaoFactory.getPermissionDao();
			logger.info("permissionDao");
			result = permissionDao.permissionInsert(con, permission);
			logger.info("reult::" + result);
			con.commit();
			logger.info("con.commit");

		} catch (Exception e) {
			con.rollback();
			logger.error("problem PermissionServiceImpl::" + e);
		} finally {
			con.close();
			logger.info("con.close");
		}
		return result;
	}

	public int permissionUpdate(Permission permission) throws SQLException,
			ClassNotFoundException {

		Connection con = null;
		con = ConnectionUtility.createConnection();
		PermissionDao permissionDao = DaoFactory.getPermissionDao();

		int result = 0;
		try {
			con.setAutoCommit(false);
			result = permissionDao.permissionUpdate(con, permission);
			System.out.println(result);
			con.commit();

		} catch (Exception e) {
			System.out.println("problem in service class" + e);
			con.rollback();
		} finally {
			con.close();
		}
		return result;
	}

	public int permissionDelete(Permission permission) throws SQLException,
			ClassNotFoundException {

		Connection con = null;
		con = ConnectionUtility.createConnection();
		PermissionDao permissionDao = DaoFactory.getPermissionDao();

		int result = 0;
		try {
			con.setAutoCommit(false);

			result = permissionDao.permissionDelete(con, permission);
			System.out.println("permissionDao");
			con.commit();

		} catch (Exception e) {
			System.out.println("problem in service class " + e);
			con.rollback();
		} finally {
			con.close();
		}
		return result;
	}

	public List permissionSelect(Permission permission) throws SQLException,
			ClassNotFoundException {

		List result = null;
		Connection con = null;
		con = ConnectionUtility.createConnection();
		System.out.println("Connection created " + con);

		try {
			PermissionDao permissionDao = DaoFactory.getPermissionDao();
			con.setAutoCommit(false);
			result = permissionDao.permissionSelect(con, permission);
			System.out.println(" result " + result);
			con.commit();

		} catch (Exception e) {
			System.out.println("problem in service class " + e);
			con.rollback();
		} finally {
			con.close();
		}
		return result;

	}

}