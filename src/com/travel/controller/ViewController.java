package com.travel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/")
@Controller
public class ViewController {
	
	//登录页面
	@RequestMapping(value = "index.do")
	public String index(HttpServletRequest req){
		return "index";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "login.do")
	public String login(HttpServletRequest req, HttpServletResponse res, Map model){
		res.setContentType("text/html;charset=UTF-8");
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		if((!userName.equals("admin"))||(!password.equals("travel"))){
			model.put("loginSuccess", false);
			return "index";
		}
		else{
			model.put("loginSuccess", true);
			try {
				session.setAttribute("authorization", true);
				res.sendRedirect("travelLines.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "travelLines";
		}
	}
	
	//后台首页
	@RequestMapping(value = "travelLines.do")
	public String adminIndex(HttpServletRequest req){
		return "travelLines";
	}
		
	//登出链接
	@RequestMapping(value = "exit.do")
	public void exit(HttpServletRequest req, HttpServletResponse res){
		HttpSession session=req.getSession();
		session.removeAttribute("authorization");
		try {
			res.sendRedirect("index.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
