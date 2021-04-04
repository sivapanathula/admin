package com.vcs.admin.role.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.common.factory.DaoFactory;
import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.ConnectionUtility;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.role.dao.RoleDao;
import com.vcs.admin.role.model.Roles;
import com.vcs.admin.role.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private static ILogger logger = Log4jUtil.getLogger(RoleServiceImpl.class);

	public int roleInsert(Roles role) throws SQLException {
		logger.info("RoleServiceImpl roleInsert method");
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionUtility.createConnection();
			logger.debug("RoleServiceImpl Connnection");
			con.setAutoCommit(false);
			logger.info("RoleServiceImpl setAutoCommit");
			RoleDao roleDao = DaoFactory.getRoleDao();
			logger.debug("RoleServiceImpl roleDao object");
			result = roleDao.roleInsert(con, role);
			logger.debug("RoleServiceImpl result");
			con.commit();
			logger.debug("RoleServiceImpl con.commit");
		} catch (Exception e) {
			con.rollback();
			logger.error("RoleServiceImpl connection roleback");
		} finally {
			con.close();
			logger.error("RoleServiceImpl connection close");
		}

		return result;
	}

	public int roleUpdate(Roles role) throws SQLException {
		logger.info("RoleServiceImpl roleUpdate method");
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionUtility.createConnection();
			logger.debug("RoleServiceImpl Connnection");
			con.setAutoCommit(false);
			logger.info("RoleServiceImpl setAutoCommit");
			RoleDao roleDao = DaoFactory.getRoleDao();
			logger.debug("RoleServiceImpl roleDao object");
			result = roleDao.roleUpdate(con, role);
			logger.debug("RoleServiceImpl result");
			con.commit();
			logger.debug("RoleServiceImpl con.commit");
		} catch (Exception e) {
			con.rollback();
			logger.error("RoleServiceImpl connection roleback");
		} finally {
			con.close();
			logger.error("RoleServiceImpl connection close");
		}

		return result;
	}

	public int roleDelete(Roles role) throws SQLException {
		logger.info("RoleServiceImpl roleUpdate method");
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionUtility.createConnection();
			logger.debug("RoleServiceImpl Connnection");
			con.setAutoCommit(false);
			logger.info("RoleServiceImpl setAutoCommit");
			RoleDao roleDao = DaoFactory.getRoleDao();
			logger.debug("RoleServiceImpl roleDao object");
			result = roleDao.roleDelete(con, role);
			logger.debug("RoleServiceImpl result");
			con.commit();
			logger.debug("RoleServiceImpl con.commit");
		} catch (Exception e) {
			con.rollback();
			logger.error("RoleServiceImpl connection roleback");
		} finally {
			con.close();
			logger.error("RoleServiceImpl connection close");
		}

		return result;
	}

	public List roleSelect(Roles role) throws SQLException {
		logger.info("RoleServiceImpl roleSelecct method");
		Connection con = null;
		List result = null;
		try {
			con = ConnectionUtility.createConnection();
			logger.debug("RoleServiceImpl Connnection");
			con.setAutoCommit(false);
			logger.info("RoleServiceImpl setAutoCommit");
			RoleDao roleDao = DaoFactory.getRoleDao();
			logger.debug("RoleServiceImpl roleDao object");
			result = roleDao.roleSelect(con, role);
			logger.debug("RoleServiceImpl result");
			con.commit();
			logger.debug("RoleServiceImpl con.commit");
		} catch (Exception e) {
			con.rollback();
			logger.error("RoleServiceImpl connection roleback");
		} finally {
			con.close();
			logger.error("RoleServiceImpl connection close");
		}

		return result;

	}
}
