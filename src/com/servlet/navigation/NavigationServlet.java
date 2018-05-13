package com.servlet.navigation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

import net.sf.json.JSONObject;

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
		Map topMenu=new HashMap();
		Map leftMenu=new HashMap();
		leftMenu.put("name", "部门中心");
		leftMenu.put("url", "left.jsp?menu=0");
		topMenu.put("0", leftMenu);
		
		leftMenu=new HashMap();
		leftMenu.put("name", "员工中心");
		leftMenu.put("url", "left.jsp?menu=1");
		topMenu.put("1", leftMenu);
		
		leftMenu=new HashMap();
		leftMenu.put("name", "考勤中心");
		leftMenu.put("url", "left.jsp?menu=1");
		topMenu.put("2", leftMenu);
		
		leftMenu=new HashMap();
		leftMenu.put("name", "工资中心");
		leftMenu.put("url", "left.jsp?menu=1");
		topMenu.put("3", leftMenu);
		
		leftMenu=new HashMap();
		leftMenu.put("name", "个人中心");
		leftMenu.put("url", "left.jsp?menu=1");
		topMenu.put("4", leftMenu);
		
		leftMenu=new HashMap();
		leftMenu.put("name", "系统设置");
		leftMenu.put("url", "left.jsp?menu=1");
		topMenu.put("4", leftMenu);
		
		JSONObject jsonObject = JSONObject.fromObject(topMenu);
		
		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
		return "";
	}

	// 初始化左侧导航栏
	protected String loadLeftNavigation(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map allMenu=new HashMap();
		
		Map topMenu=new HashMap();
		Map leftMenu=new HashMap();
		leftMenu.put("name", "部门信息");
		leftMenu.put("url", "dept.jsp");
		topMenu.put("0", leftMenu);
		leftMenu=new HashMap();
		leftMenu.put("name", "岗位信息");
		leftMenu.put("url", "position.jsp");
		topMenu.put("1", leftMenu);
		
		allMenu.put("0", topMenu);
		
		topMenu=new HashMap();
		leftMenu=new HashMap();
		leftMenu.put("name", "部门信息1");
		leftMenu.put("url", "#");
		topMenu.put("0", leftMenu);
		leftMenu=new HashMap();
		leftMenu.put("name", "岗位信息1");
		leftMenu.put("url", "#");
		topMenu.put("1", leftMenu);
		
		allMenu.put("1", topMenu);
		
		JSONObject jsonObject = JSONObject.fromObject(allMenu);
		
		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
		return "";
	}
}
