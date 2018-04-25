package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4570656216703421100L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String methodname = request.getParameter("method");
		Class<?> cla = this.getClass();
		try {
			Method method = cla.getDeclaredMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			String path = (String) method.invoke(this, request, response);
			if (path != null && path!="") {
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
