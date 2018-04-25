package com.servlet.navigation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

/**
 * 负责导航栏相关信息
 * 
 * @author MBENBEN
 *
 */
public class NavigationServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8947346236036128802L;

	// 初始化头部导航栏
	protected String loadTopNavigation(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String json = "[{\"name\":\"部门中心\",\"url\":\"#\"},{\"name\":\"员工中心\",\"url\":\"#\"},{\"name\":\"考勤中心\",\"url\":\"#\"},{\"name\":\"工资中心\",\"url\":\"#\"},{\"name\":\"个人中心\",\"url\":\"#\"},{\"name\":\"系统设置\",\"url\":\"#\"}]";
		PrintWriter out = response.getWriter();
		out.write(json);
		return "";
	}

	// 初始化左侧导航栏
	protected String loadLeftNavigation(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String json = "[{\"name\":\"部门信息\",\"url\":\"#\"},{\"name\":\"岗位信息\",\"url\":\"#\"}]";
		PrintWriter out = response.getWriter();
		out.write(json);
		return "";
	}
}
