package com.vcs.admin.permission.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basecontroller.BaseController;
import com.vcs.admin.common.adminconstant.AdminConstant;
import com.vcs.admin.common.factory.ServiceFactory;
import com.vcs.admin.permission.model.Permission;
import com.vcs.admin.permission.service.PermissionService;

public class PermissionController extends BaseController {

	// insert method
	public void permissionInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("execute method in controller 1");

		Permission permission = new Permission();
		populate(request, permission);

		System.out.println("calling model & polpulate in controller 2" + permission);

		PermissionService permissionService = ServiceFactory.getPermissionService();

		System.out.println("calling service in controller");
		// calling service

		int result = 0;
		String page = "";
		try {
			result = permissionService.permissionInsert(permission);

			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
			} else {
				page = AdminConstant.FAILURE_PAGE;
				System.out.println("forward req, res, page in controller");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		forward(request, response, page);
	}

	// update method
	public void permissionUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int result = 0;
		String page = "";
		Permission permission = new Permission();
		populate(request, permission);
		System.out.println("data populate" + permission);
		PermissionService permissionService = ServiceFactory.getPermissionService();

		// calling service

		try {
			result = permissionService.permissionUpdate(permission);

			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
			} else {
				page = AdminConstant.FAILURE_PAGE;
				System.out.println("forward req, res, page in controller");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		forward(request, response, page);
	}

	// delete method
	public void permissionDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("execute method in controller 1");

		Permission permission = new Permission();
		populate(request, permission);

		System.out.println("calling model & polpulate in controller 2");

		PermissionService permissionService = ServiceFactory.getPermissionService();

		System.out.println("calling service in controller");
		// calling service

		int result = 0;
		String page = "";
		try {
			result = permissionService.permissionDelete(permission);

			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
			} else {
				page = AdminConstant.FAILURE_PAGE;
				System.out.println("forward req, res, page in controller");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		forward(request, response, page);
	}

	// select method

	public void permissionSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("execute method in controller 1");

		Permission permission = new Permission();
		// populate(request, permission);

		System.out.println("calling model & polpulate in controller 2");
		PermissionService permissionService = ServiceFactory.getPermissionService();
		System.out.println("calling service in controller 3");
		// calling service

		// List result = null;
		String page = "";
		try {
			List result = permissionService.permissionSelect(permission);
			request.setAttribute("List", result);
			System.out.println("result " + result);

			page = AdminConstant.PERMISSION_PAGE;

		} catch (Exception e) {
			System.out.println(e);
		}
		forward(request, response, page);

	}

}
