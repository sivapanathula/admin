package com.vcs.user.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.vcs.admin.common.factory.DaoFactory;
import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.ConnectionUtility;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.user.dao.UserDao;
import com.vcs.admin.user.model.User;
import com.vcs.user.service.UserService;

public class UserServiceImpl implements UserService {

	private static ILogger logger = Log4jUtil.getLogger(UserServiceImpl.class);

	public int userInsert(User user) throws SQLException,
			ClassNotFoundException {
		logger.info("UserServiceImpl userInsert");
		int result = 0;
		Connection con = null;

		try {
			con = ConnectionUtility.createConnection();
			logger.debug("UserServiceImpl Connection");
			con.setAutoCommit(false);
			logger.debug("UserServiceImpl businesslogic");
			UserDao userDao = DaoFactory.getUserDao();
			logger.debug("UserServiceImpl UserDao Object");
			result = userDao.userInsert(con, user);
			logger.debug("UserServiceImpl UserInsert");
			con.commit();
			logger.info("UserServiceImpl con.commit");
		} catch (Exception e) {
			con.rollback();
			logger.error("UserServiceImpl Exception :" + e);
		} finally {
			con.close();
			logger.info("UserServiceImpl con.close");
		}
		return result;
	}

	public int userUpdate(User user) throws SQLException,
			ClassNotFoundException {
		logger.info("UserServiceImpl userUpdate");
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionUtility.createConnection();
			logger.debug("UserServiceImpl ConObj");
			UserDao userDao = DaoFactory.getUserDao();
			logger.debug("UserServiceImpl userDaoObj");
			con.setAutoCommit(false);
			logger.debug("UserServiceImpl BusinessLogic");
			result = userDao.userUpdate(con, user);
			logger.debug("UserServiceImpl userUpdate");
			con.commit();
			logger.info("UserServiceImpl con.commit");

		} catch (Exception e) {
			con.rollback();
			logger.error("UserServiceImpl Exception :" + e);
		} finally {
			con.close();
			logger.info("UserServiceImpl con.close");
		}
		return result;
	}

	public int userDelete(User user) throws SQLException,
			ClassNotFoundException {
		logger.info("UserServiceImpl con.userDelete");
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionUtility.createConnection();
			logger.info("UserServiceImpl connection");
			UserDao userDao = DaoFactory.getUserDao();
			logger.debug("UserServiceImpl userDao Obj");
			con.setAutoCommit(false);
			logger.info("UserServiceImpl BusinessLogic");
			result = userDao.userDelete(con, user);
			logger.debug("UserServiceImpl userDelete");
			con.commit();
			logger.info("UserServiceImpl con.commit");
		} catch (Exception e) {
			logger.error("UserServiceImpl Exception : " + e);
			con.rollback();
			logger.info("UserServiceImpl con.rollback ");
		} finally {
			con.close();
			logger.info("UserServiceImpl con.Close ");
		}
		return result;
	}

	public List<User> userSelect(User user) throws SQLException,
			ClassNotFoundException {
		logger.info("userselect method");
		List<User> result = null;
		Connection con = null;
		try {
			con = ConnectionUtility.createConnection();
			logger.info("Connection ");
			con.setAutoCommit(false);
			logger.info("Transaction logic ");
			UserDao userDao = DaoFactory.getUserDao();
			logger.debug("UserDao Object ");
			result = userDao.userSelect(con, user);
			logger.debug("Get result from UserDao " + result);
			con.commit();
			logger.info("Connection Commit");
		} catch (Exception e) {
			con.rollback();
			logger.error("Connection RollBack");
		} finally {
			con.close();
			logger.info("Connection close");
		}
		return result;
	}

}
