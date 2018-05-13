package com.servlet.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

import net.sf.json.JSONObject;

public class DeptServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8071783647280270074L;

	// 查询部门显示字段
	protected void findDeptField(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Map dept = new HashMap();
		Map deptField = new HashMap();
		deptField.put("colname", "deptid");
		deptField.put("chinese_name", "部门id");
		dept.put("0", deptField);

		deptField = new HashMap();
		deptField.put("colname", "deptcode");
		deptField.put("chinese_name", "部门编码");
		dept.put("1", deptField);

		deptField = new HashMap();
		deptField.put("colname", "deptname");
		deptField.put("chinese_name", "部门名称");
		dept.put("2", deptField);

		deptField = new HashMap();
		deptField.put("colname", "father");
		deptField.put("chinese_name", "父部门");
		dept.put("3", deptField);

		JSONObject jsonObject = JSONObject.fromObject(dept);

		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
	}

	// 查询部门具体信息
	protected void findDeptInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		 String deptId = request.getParameter("TreeNodeId");
		 
		 System.out.println(deptId);
		
		Map dept = new HashMap();
		Map deptInfo = new HashMap();
		deptInfo.put("field", "deptid");
		deptInfo.put("value", "1");
		dept.put("0", deptInfo);

		deptInfo = new HashMap();
		deptInfo.put("field", "deptcode");
		deptInfo.put("value", "1");
		dept.put("1", deptInfo);

		deptInfo = new HashMap();
		deptInfo.put("field", "deptname");
		deptInfo.put("value", "集团");
		dept.put("2", deptInfo);

		deptInfo = new HashMap();
		deptInfo.put("field", "father");
		deptInfo.put("value", "");
		dept.put("3", deptInfo);

		JSONObject jsonObject = JSONObject.fromObject(dept);

		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
	}

	// 新增部门
	protected void addDpte(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("asfasdf");
		// request.getRequestDispatcher("Success.jsp").forward(request,
		// response);
		response.sendRedirect("dept.jsp");
	}

	// 删除部门
	protected void deleteDpte(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String TreeNodeId = (String) request.getAttribute("TreeNodeId");
		response.sendRedirect("dept.jsp");
	}

	// 修改部门
	protected void updateDpte(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String TreeNodeId = (String) request.getAttribute("TreeNodeId");

		response.sendRedirect("dept.jsp");
	}

}
