package com.servlet.position;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

import net.sf.json.JSONObject;

public class PositionServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6628666307578885929L;

	// 查询岗位显示字段
	protected void findPositionField(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Map position = new HashMap();
		Map positionField = new HashMap();
		positionField.put("colname", "positionid");
		positionField.put("chinese_name", "部门id");
		position.put("0", positionField);

		positionField = new HashMap();
		positionField.put("colname", "positioncode");
		positionField.put("chinese_name", "部门编码");
		position.put("1", positionField);

		positionField = new HashMap();
		positionField.put("colname", "positionname");
		positionField.put("chinese_name", "部门名称");
		position.put("2", positionField);

		positionField = new HashMap();
		positionField.put("colname", "father");
		positionField.put("chinese_name", "父部门");
		position.put("3", positionField);

		JSONObject jsonObject = JSONObject.fromObject(position);

		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
	}

	// 查询岗位具体信息
	protected void findPositionInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String positionId = request.getParameter("TreeNodeId");

		System.out.println(positionId);

		Map position = new HashMap();
		Map positionInfo = new HashMap();
		positionInfo.put("field", "positionid");
		positionInfo.put("value", "1");
		position.put("0", positionInfo);

		positionInfo = new HashMap();
		positionInfo.put("field", "positioncode");
		positionInfo.put("value", "1");
		position.put("1", positionInfo);

		positionInfo = new HashMap();
		positionInfo.put("field", "positionname");
		positionInfo.put("value", "集团");
		position.put("2", positionInfo);

		positionInfo = new HashMap();
		positionInfo.put("field", "father");
		positionInfo.put("value", "");
		position.put("3", positionInfo);

		JSONObject jsonObject = JSONObject.fromObject(position);

		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
	}

}
