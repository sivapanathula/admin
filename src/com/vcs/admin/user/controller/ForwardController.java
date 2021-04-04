package com.vcs.admin.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basecontroller.BaseController;

public class ForwardController extends BaseController {
	protected void forward(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		forward(request, response, page);
	}
}
