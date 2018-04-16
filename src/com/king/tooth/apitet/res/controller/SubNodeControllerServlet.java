package com.king.tooth.apitet.res.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.king.tooth.apitet.res.entity.ParentNode;
import com.king.tooth.apitet.res.hibernateutil.CloseUtil;
import com.king.tooth.apitet.res.service.SubNodeService;

/**
 * Res控制器的api测试
 * @author StoneKing
 */
public class SubNodeControllerServlet extends HttpServlet {
	
	/**
	 * 获取所有的资源树JSON串
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SubNodeService service =  new SubNodeService();
		List<ParentNode> resTreeNode = service.findAllDymResModule();
		PrintWriter out = resp.getWriter();
		System.out.println(JSONArray.toJSONString(resTreeNode));
		out.print(JSONArray.toJSONString(resTreeNode));
		CloseUtil.closeIO(out);
	}
}
