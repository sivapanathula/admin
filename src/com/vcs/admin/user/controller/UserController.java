package com.vcs.admin.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.basecontroller.BaseController;
import com.vcs.admin.common.adminconstant.AdminConstant;
import com.vcs.admin.common.factory.ServiceFactory;
import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.user.model.User;
import com.vcs.user.service.UserService;

public class UserController extends BaseController {
	private static final long serialVersionUID = 1L;
	public static ILogger logger = Log4jUtil.getLogger(UserController.class);

	protected void userLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ClassNotFoundException, SQLException {
		if ((Boolean) request.getAttribute("capchaSuccess") != null) {
			if (!(Boolean) request.getAttribute("capchaSuccess")) {
				request.setAttribute("emailId", request.getParameter("emailId"));
				request.setAttribute("password",
						request.getParameter("password"));
				request.setAttribute("status", "please enter valid captcha");
				forward(request, response, "userlogin.jsp");
			}
		}
		logger.info("userLogIn Method");
		User user = new User();
		logger.debug("userLogIn user Object");
		populate(request, user);
		logger.debug("userLogIn user populate ");
		UserService userService = ServiceFactory.getUserService();
		logger.debug("userLogIn user UserServiceObject ");
		if (StringUtils.isEmpty(user.getEmailId())
				|| StringUtils.isEmpty(user.getPassword())) {
			response.sendRedirect("userLogin.jsp");
			List list = userService.userSelect(user);
			try {
				list = userService.userSelect(user);
				if (!list.isEmpty()) {
					User dbuser = (User) list.get(0);
					request.getSession().setAttribute("user", dbuser);
					response.sendRedirect("userLogin.jsp");
				}
				response.sendRedirect("userLogin.jsp");
			} catch (SQLException e) {

				logger.error("userLogin problem ::" + e);
			} catch (ClassNotFoundException e) {
				logger.error("userLogin problem ::" + e);
			}
		}
	}

	// insert method
	public void userInsert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("insertMethod");
		User user = new User();
		populate(request, user);
		logger.debug("populateMethod");

		// calling service

		int result = 0;
		String page = "";
		try {
			UserService userService = ServiceFactory.getUserService();
			logger.debug("UserController insert userServiceObj");
			result = userService.userInsert(user);
			logger.debug("UserController userInsert");
			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
				logger.info("UserController SUCCESS_PAGE");
			} else {
				page = AdminConstant.FAILURE_PAGE;
				logger.info("UserController FAILURE_PAGE");
			}
		} catch (Exception e) {
			logger.error("UserController Exception :" + e);
		}
		forward(request, response, page);
		logger.info("UserController forward Req, Res, Page");
	}

	// update method
	public void userUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("userUpdate");
		User user = new User();
		logger.debug("userUpdate UserObject");
		populate(request, user);
		logger.debug("erObject populate");

		// calling service

		int result = 0;
		String page = "";
		try {
			UserService userServiceImpl = ServiceFactory.getUserService();
			logger.debug("userUpdate userServiceImpl");
			result = userServiceImpl.userUpdate(user);
			logger.debug("userUpdate result");

			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
				logger.info("userUpdate SUCCESS_PAGE");
			} else {
				page = AdminConstant.FAILURE_PAGE;
				logger.info("userUpdate FAILURE_PAGE");
			}
		} catch (Exception e) {
			logger.error("userUpdate Exception ::" + e);
		}
		forward(request, response, page);
		logger.info("userUpdate forward page");
	}

	// delete method

	public void userDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("userDelete");

		User user = new User();
		logger.debug("userDelete user ");
		populate(request, user);
		logger.debug("userDelete populate ");
		// calling service

		int result = 0;
		String page = "";
		try {
			UserService userService = ServiceFactory.getUserService();
			logger.debug("userDelete userServiceObj ");
			result = userService.userDelete(user);
			logger.debug("userDelete result");
			if (result > 0) {
				page = AdminConstant.SUCCESS_PAGE;
				logger.info("userDelete SUCCESS_PAGE");
			} else {
				page = AdminConstant.FAILURE_PAGE;
				logger.info("userDelete FAILURE_PAGE");
			}
		} catch (Exception e) {
			logger.error("userDelete Exception ::" + e);
		}
		forward(request, response, page);
		logger.info("userDelete forward Page");
	}

	// select method

	public void userSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("userselect method");
		User user = new User();
		populate(request, user);
		logger.info("UserData Populated");
		String page = "";
		try {
			UserService userService = ServiceFactory.getUserService();
			logger.debug("UserService method");
			List<User> result = userService.userSelect(user);
			logger.info("Get the result from userService :" + result);
			request.setAttribute("userList", result);
			logger.info("setAtribute" + result);
			page = AdminConstant.SELECT_PAGE;
		} catch (Exception e) {
			System.out.println(e);
		}
		forward(request, response, page);
		logger.info("forward the page");
	}

	protected void userLogout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("userLogout method");
		try {
			request.getSession().invalidate();
			logger.debug("invalidate session");
			response.sendRedirect("userLogin.jsp");
			logger.info("sendRedirect");
		} catch (IOException e) {
			logger.error("LogOut proble");
		}
	}
}
