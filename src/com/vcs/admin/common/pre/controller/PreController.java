package com.vcs.admin.common.pre.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basecontroller.BaseController;
import com.vcs.admin.common.factory.ServiceFactory;
import com.vcs.admin.permission.model.Permission;
import com.vcs.admin.permission.service.PermissionService;
import com.vcs.admin.role.model.Roles;
import com.vcs.admin.role.service.RoleService;

public class PreController extends BaseController {
	public void loadRoles(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException {
		String page = "";
		Roles role = new Roles();
		RoleService roleService = ServiceFactory.getRoleService();
		try {
			List result = roleService.roleSelect(role);
			request.setAttribute("userList", result);
			page = "userRegistrationForm.jap";
		} catch (SQLException e) {
			System.out.println(e);
		}
		try {
			forward(request, response, page);
		} catch (ServletException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void loadPermission(HttpServletRequest request,
			HttpServletResponse response) {
		String page = "";
		Permission permission = new Permission();
		PermissionService permissionService = ServiceFactory
				.getPermissionService();
		try {
			List result = permissionService.permissionSelect(permission);
			page = "roleRegistrationForm.jsp";
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		try {
			forward(request, response, page);
		} catch (ServletException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
