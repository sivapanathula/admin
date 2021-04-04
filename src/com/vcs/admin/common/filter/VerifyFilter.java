package com.vcs.admin.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.util.service.Log4jUtil;

public class VerifyFilter implements Filter {
	private static ILogger logger = Log4jUtil.getLogger(VerifyFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		System.err.println("init");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		logger.info("VerifyFilter doFilter");
		if (request.getParameter("captchaField") != null
				&& rpHash(request.getParameter("captchaField")).equals(
						request.getParameter("captchaFieldHash"))) {
			request.setAttribute("capchaSuccess", true);

		} else {
			request.setAttribute("capchaSuccess", false);
			filterChain.doFilter(request, response);
			logger.debug("filterChain.doFilter");
		}
	}

	private String rpHash(String value) {
		int hash = 5381;
		value = value.toUpperCase();
		for (int i = 0; i < value.length(); i++) {
			hash = ((hash << 5) + hash) + value.charAt(i);
		}
		return String.valueOf(hash);
	}

	public void destroy() {
		System.out.println("destroy()");

	}

}
