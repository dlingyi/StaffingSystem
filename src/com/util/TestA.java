package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class TestA {
	public static void main(String[] args) {
		Map allMenu = new HashMap();

		DeptVO dv = new DeptVO("部门信息", "#");
		DeptVO dv1 = new DeptVO("部门信息1", "#");
		Map m1 = new HashMap();
		m1.put("1", dv);
		m1.put("2", dv1);
		JSONObject jsonObject1 = JSONObject.fromObject(m1);
		System.out.println("输出的结果是：" + jsonObject1);
		// 3、将json对象转化为json字符串
		String result1 = jsonObject1.toString();
		System.out.println(result1);

		Map topMenu = new HashMap();
		Map leftMenu = new HashMap();
		leftMenu.put("name", "部门信息");
		leftMenu.put("url", "#");
		topMenu.put("1", leftMenu);
		leftMenu = new HashMap();
		leftMenu.put("name", "岗位信息");
		leftMenu.put("url", "#");
		topMenu.put("2", leftMenu);

		allMenu.put("1", topMenu);

		topMenu = new HashMap();
		leftMenu = new HashMap();
		leftMenu.put("name", "部门信息1");
		leftMenu.put("url", "#");
		topMenu.put("1", leftMenu);
		leftMenu = new HashMap();
		leftMenu.put("name", "岗位信息1");
		leftMenu.put("url", "#");
		topMenu.put("2", leftMenu);

		allMenu.put("2", topMenu);
		JSONObject jsonObject = JSONObject.fromObject(allMenu);
		System.out.println("输出的结果是：" + jsonObject);
		// 3、将json对象转化为json字符串
		String result = jsonObject.toString();
		System.out.println(result);
	}
}
