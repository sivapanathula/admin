package com.basecontroller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public abstract class BaseController extends HttpServlet {

	protected final void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	protected final void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected final void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected final void forward(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected final void populate(HttpServletRequest request, Object model)
			throws ServletException, IOException {
		Map requestMap = request.getParameterMap();
		try {
			BeanUtils.populate(model, requestMap);
		} catch (Exception e) {
			System.out.println("problem in populate");
		}
	}

	protected final void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("operation");
		Method[] methods = this.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals(methodName)) {
				try {
					methods[i].invoke(this, request, response);
				} catch (Exception e) {
					System.out.println("method invoke problem");
				}

			}
		}
	}
}
