package com.vcs.admin.role.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basecontroller.BaseController;
import com.vcs.admin.common.adminconstant.AdminConstant;
import com.vcs.admin.common.factory.ServiceFactory;
import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.role.model.Roles;
import com.vcs.admin.role.service.RoleService;

@SuppressWarnings("serial")
public class RoleController extends BaseController {

	private static ILogger logger = Log4jUtil.getLogger(RoleController.class);

	public void roleInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("RoleController roleInsert method");
		Roles role = new Roles();
		logger.debug("RoleController roles Object");
		populate(request, role);
		logger.debug("RoleController roles populate");
		int result = 0;
		String page = "";
		try {
			RoleService roleService = ServiceFactory.getRoleService();
			logger.debug("RoleController rolesService Object");
			result = roleService.roleInsert(role);
			logger.debug("RoleController roles result");
			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
				logger.error("RoleController success page");
			} else {
				page = AdminConstant.FAILURE_PAGE;
				logger.error("RoleController failure page");
			}
		} catch (Exception e) {
			logger.error("RoleController " + e);
		}
		forward(request, response, page);
		logger.debug("RoleController result faoward");
	}
	
	public void roleUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("RoleController roleUpdate method");
		Roles role = new Roles();
		logger.debug("RoleController roles Object");
		populate(request, role);
		logger.debug("RoleController roles populate");
		int result = 0;
		String page = "";
		try {
			RoleService roleService = ServiceFactory.getRoleService();
			logger.debug("RoleController rolesService Object");
			result = roleService.roleUpdate(role);
			logger.debug("RoleController roles result");
			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
				logger.error("RoleController success page");
			} else {
				page = AdminConstant.FAILURE_PAGE;
				logger.error("RoleController failure page");
			}
		} catch (Exception e) {
			logger.error("RoleController " + e);
		}
		forward(request, response, page);
		logger.debug("RoleController result faoward");
	}
	
	public void roleDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("RoleController roleDelete method");
		Roles role = new Roles();
		logger.debug("RoleController roles Object");
		populate(request, role);
		logger.debug("RoleController roles populate");
		int result = 0;
		String page = "";
		try {
			RoleService roleService = ServiceFactory.getRoleService();
			logger.debug("RoleController rolesService Object");
			result = roleService.roleDelete(role);
			logger.debug("RoleController roles result");
			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
				logger.error("RoleController success page");
			} else {
				page = AdminConstant.FAILURE_PAGE;
				logger.error("RoleController failure page");
			}
		} catch (Exception e) {
			logger.error("RoleController " + e);
		}
		forward(request, response, page);
		logger.debug("RoleController result faoward");
	}
	
	public void roleSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("RoleController roleSelecct method");
		Roles role = new Roles();
		logger.debug("RoleController roles Object");
		populate(request, role);
		logger.debug("RoleController roles populate");
		String page = "";
		try {
			RoleService roleService = ServiceFactory.getRoleService();
			logger.debug("RoleController rolesService Object");
			List result = roleService.roleSelect(role);
			request.setAttribute("userList", result);
			logger.info("setAtribute" + result);
			page = AdminConstant.ROLESELECT_PAGE;
			logger.error("ROLESELECT_PAGE");
		} catch (Exception e) {
			logger.error("RoleController " + e);
		}
		forward(request, response, page);
		logger.debug("RoleController result faoward");
	}


}
