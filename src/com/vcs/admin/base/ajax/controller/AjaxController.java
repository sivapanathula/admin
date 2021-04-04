package com.vcs.admin.base.ajax.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.basecontroller.BaseController;
import com.vcs.admin.common.factory.ServiceFactory;
import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.permission.model.Permission;
import com.vcs.admin.permission.service.PermissionService;
import com.vcs.admin.user.model.User;
import com.vcs.user.service.UserService;

public class AjaxController extends BaseController {
	private static ILogger logger = Log4jUtil.getLogger(AjaxController.class);

	protected void loadAjaxPermission(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("loadAjaxPermission");
		Permission permission = new Permission();
		logger.debug("permission object");
		populate(request, permission);
		logger.debug("populate");
		PermissionService permissionService = ServiceFactory
				.getPermissionService();
		logger.debug("permissionService object");
		String page = "";
		try {
			List permissionList = permissionService
					.permissionSelect(permission);
			logger.debug("permissionList");
			if (!permissionList.isEmpty()) {
				Permission dbPermission = (Permission) permissionList.get(0);
				response.getWriter().write(dbPermission.getPermissionName());
			}
		} catch (Exception e) {
			logger.error("AjaxController Exception::" + e);
		}
	}

	protected void loadAjaxUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("loadAjaxUser");
		User user = new User();
		logger.debug("user object");
		populate(request, user);
		logger.debug("populate");
		UserService userService = ServiceFactory.getUserService();
		logger.debug("permissionService object");
		try {
			List userList = userService.userSelect(user);
			logger.debug("userList");
			if (!userList.isEmpty()) {
				User dbUser = (User) userList.get(0);
				ObjectMapper mapper = new ObjectMapper();
				response.getWriter().write(mapper.writeValueAsString(dbUser));
			} else {
				response.getWriter().write("invalid User Id");
			}
		} catch (Exception e) {
			logger.error("loadAjaxUser Exception::" + e);
		}

	}
}
