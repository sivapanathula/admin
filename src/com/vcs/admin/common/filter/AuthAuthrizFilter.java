package com.vcs.admin.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.Log4jUtil;
import com.vcs.admin.user.model.User;

public class AuthAuthrizFilter implements Filter {
	private static ILogger logger = Log4jUtil
			.getLogger(AuthAuthrizFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init()");

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		logger.info("AuthAuthrizFilter doFilter method");
		HttpServletRequest req = (HttpServletRequest) request;
		logger.debug("HttpServletRequest");
		HttpServletResponse res = (HttpServletResponse) response;
		logger.debug("HttpServletResponse");
		HttpSession session = req.getSession();
		logger.debug("HttpSession ::" + session);
		User user = (User) session.getAttribute("user");
		logger.debug("User session::" + user);
		String operation = request.getParameter("operation");
		logger.debug("String operation::" + operation);

		if ((operation.equals("userLogin") || user != null)) {
			filterChain.doFilter(req, res);
		} else {
			((HttpServletResponse) res).sendRedirect("userLogin.jsp");
			logger.debug("sendRedirect userLogin.jsp");
		}
	}

	public void destroy() {
		System.out.println("destroy()");
	}

}
