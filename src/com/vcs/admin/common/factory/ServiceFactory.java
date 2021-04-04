package com.vcs.admin.common.factory;

import com.vcs.admin.permission.service.PermissionService;
import com.vcs.admin.permission.service.impl.PermissionServiceImpl;
import com.vcs.admin.role.service.RoleService;
import com.vcs.admin.role.service.impl.RoleServiceImpl;
import com.vcs.user.service.UserService;
import com.vcs.user.service.impl.UserServiceImpl;

public class ServiceFactory {
	private void ServiceFactry() {

	}

	private static UserService userService = null;
	private static RoleService roleService = null;
	private static PermissionService permissionService = null;

	public static UserService getUserService() {
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	public static RoleService getRoleService() {
		if (roleService == null) {
			roleService = new RoleServiceImpl();
		}
		return roleService;
	}
	
	public static PermissionService getPermissionService() {
		if (permissionService == null) {
			permissionService = new PermissionServiceImpl();
		}
		return permissionService;
	}

}