package com.servlet.depttree;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

import net.sf.json.JSONArray;

public class DeptTreeServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8700829115835002260L;
//初始化树
	protected String loadTree(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String json = "[{\"id\":\"1\",\"pId\":\"0\",\"name\":\"集团\"},{\"id\":\"2\",\"pId\":\"1\",\"name\":\"总公司\"},{\"id\":\"3\",\"pId\":\"1\",\"name\":\"江西子公司\"},{\"id\":\"4\",\"pId\":\"1\",\"name\":\"北京子公司\"},{\"id\":\"10\",\"pId\":\"1\",\"name\":\"安徽子公司\"},{\"id\":\"5\",\"pId\":\"2\",\"name\":\"人力资源部\"},{\"id\":\"6\",\"pId\":\"2\",\"name\":\"财务部\"},{\"id\":\"7\",\"pId\":\"2\",\"name\":\"行政部\"},{\"id\":\"8\",\"pId\":\"3\",\"name\":\"客服部\"},{\"id\":\"9\",\"pId\":\"4\",\"name\":\"技术部\"}]";
		PrintWriter out = response.getWriter(); 
		out.write(json);
		return "";
	}
}
