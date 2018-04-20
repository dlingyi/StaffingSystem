package com.dwl;

import java.io.IOException;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodname = request.getParameter("method");
		Class<?> cla = this.getClass();
		try {
			Method method = cla.getDeclaredMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			String path = (String) method.invoke(this, request, response);
			if (path != null) {
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void first(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<br/>");
		out.write("first");
		out.close();
	}

	protected void second(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<br/>");
		out.write("second");
		out.close();
	}

	protected void third(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<br/>");
		out.write("third");
		out.close();
	}

}
