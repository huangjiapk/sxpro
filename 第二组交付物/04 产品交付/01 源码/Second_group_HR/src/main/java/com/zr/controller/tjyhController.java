package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.tjyhService;

public class tjyhController extends HttpServlet {

	tjyhService tjyh = new tjyhService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{

		
		req.setCharacterEncoding("utf8");
		String name = req.getParameter("name");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String lvl = req.getParameter("lvl");
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String annTime = dateFormat.format(date);
		//有个保存用户的服务
		boolean  flag = tjyh.tjyhByYhName(name,uname,pwd,lvl,annTime);
		Boolean  f =  new Boolean(flag);
		PrintWriter  wr =  resp.getWriter();
		wr.write(f.toString());
		wr.flush();
		wr.close();
	}
}
