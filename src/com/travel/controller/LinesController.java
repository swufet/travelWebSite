package com.travel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.xwork2.ActionContext;
import com.travel.dao.GuidesDao;
import com.travel.dao.TravelLinesDao;
import com.travel.entity.*;
@RequestMapping("/")
@Controller
public class LinesController {
	
	private static final List TravelLines = null;

	@Autowired
	TravelLinesDao travelLinesDao;
	
	@Autowired
	GuidesDao guidesDao;
	
	
	//登录权限验证
	private void checkAuth(HttpServletRequest req, HttpServletResponse res){
		HttpSession session=req.getSession();
		Object auth=session.getAttribute("authorization");
		if(auth == null){
			try {
				res.sendRedirect("index.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//登录页面
	@RequestMapping(value = "index.do")
	public String index(HttpServletRequest req){
		return "index";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "login.do")
	public void login(HttpServletRequest req, HttpServletResponse res, Map model){
		res.setContentType("text/html;charset=UTF-8");
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		if((!userName.equals("admin"))||(!password.equals("travel"))){
			model.put("loginSuccess", false);
			try {
				res.sendRedirect("index.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			model.put("loginSuccess", true);
			try {
				session.setAttribute("authorization", true);
				res.sendRedirect("travel_lines.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//后台首页
	@RequestMapping(value = "travel_lines.do")
	public String adminIndex(HttpServletRequest req, HttpServletResponse res,Map model){
		checkAuth(req,res);
		List list = (List<TravelLines>)travelLinesDao.getAll();
		model.put("lines", list);
		return "travel_lines";
	}
	
	//进入增加旅游路线页面
	@RequestMapping(value = "add_new_line.do")
	public String addLine(HttpServletRequest req, HttpServletResponse res,Map model){
		checkAuth(req,res);
		TravelLines line=new TravelLines();
		travelLinesDao.save(line);
		model.put("line", line);
		return "update_line";
	}
	
	//进入更新旅游路线页面
	@RequestMapping(value = "update_line_{id}.do")
	public String updateLine(@PathVariable int id, HttpServletRequest req, HttpServletResponse res,Map model){
		checkAuth(req,res);
		TravelLines line=(TravelLines) travelLinesDao.getById(id);
		model.put("line", line);
		return "update_line";
	}
	
	//删除一个旅游路线
	@RequestMapping(value = "delete_line_{id}.do")
	public void deleteLine(@PathVariable int id,HttpServletRequest req, HttpServletResponse res){
		checkAuth(req,res);
		travelLinesDao.deleteById(id);
		travelLinesDao.commit();
//		try {
//			res.sendRedirect("travel_lines.do");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	//更新旅游路线
	@RequestMapping(value = "save_line_{id}.do")
	public String saveUpdateLine_(@PathVariable int id, Map model, TravelLines line,HttpServletRequest req, HttpServletResponse res){
		checkAuth(req,res);
		line.setId(id);
		travelLinesDao.update(line);
		travelLinesDao.commit();
		model.put("line", line);
		return "update_line";
	}
		
	//登出链接
	@RequestMapping(value = "exit.do")
	public void exit(HttpServletRequest req, HttpServletResponse res){
		HttpSession session=req.getSession();
		session.removeAttribute("authorization");
		try {
			res.sendRedirect("index.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//前台旅游线路列表
	@RequestMapping(value = "front_lines.do")
	public String frontIndex(Map model){
		List list = (List<TravelLines>)travelLinesDao.getAll();
		model.put("lines", list);
		return "front_lines";
	}
	
	//旅游线路详细页
	@RequestMapping(value = "front_line_{id}.do")
	public String lineDetail(@PathVariable int id, Map model){
		TravelLines line=(TravelLines) travelLinesDao.getById(id);
		model.put("line", line);
		return "front_line_detail";
	}
	
	
}
