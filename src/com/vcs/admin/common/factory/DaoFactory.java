package com.vcs.admin.common.factory;

import com.vcs.admin.permission.dao.PermissionDao;
import com.vcs.admin.permission.dao.impl.PermissionDaoImpl;
import com.vcs.admin.role.dao.RoleDao;
import com.vcs.admin.role.dao.impl.RoleDaoImpl;
import com.vcs.admin.user.dao.UserDao;
import com.vcs.admin.user.dao.impl.UserDaoImpl;

public class DaoFactory {
	private void DaoFactroy() {

	}

	private static UserDao userDao = null;
	private static RoleDao roleDao = null;
	private static PermissionDao permissionDao = null;

	public static UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

	public static RoleDao getRoleDao() {
		if (roleDao == null) {
			roleDao = new RoleDaoImpl();
		}
		return roleDao;
	}
	public static PermissionDao getPermissionDao() {
		if (permissionDao == null) {
			permissionDao = new PermissionDaoImpl();
		}
		return permissionDao;
	}
}
