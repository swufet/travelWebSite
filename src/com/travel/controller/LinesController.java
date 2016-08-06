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
import com.travel.dao.*;
import com.travel.entity.*;
import com.travel.util.*;
@RequestMapping("/")
@Controller
public class LinesController {
	
	private static final List TravelLines = null;

	@Autowired
	TravelLinesDao travelLinesDao;
	
	@Autowired
	PwdDao pwdDao;
	
	
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
		if(pwdDao.getById(1)==null){
			CipherUtil cipher = new CipherUtil();  
			String pwd="travel";
			String pwdMd5=cipher.generatePassword(pwd);
			Pwd newpwd=new Pwd();
			newpwd.setPwd(pwdMd5);
			pwdDao.save(newpwd);
			pwdDao.commit();
		}
		return "index";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "login.do")
	public String login(HttpServletRequest req, HttpServletResponse res, Map model){
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession();
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		Pwd myPwd=(Pwd) pwdDao.getById(1);
		String passwordMd5=myPwd.getPwd();
		CipherUtil cipher = new CipherUtil();  
		if(userName.equals("admin")&&cipher.validatePassword(passwordMd5, password)){
			session.setAttribute("authorization", true);
			model.put("loginSuccess", true);
			List list = (List<TravelLines>)travelLinesDao.getAll();
			model.put("lines", list);
			return "travel_lines";
		}
		else{
			model.put("loginSuccess", false);
			return "index";
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
	public String saveUpdateLine(@PathVariable int id, Map model, TravelLines line,HttpServletRequest req, HttpServletResponse res){
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
	
	//进入更改密码页面
	@RequestMapping(value = "change_pwd.do")
	public String changePwd(HttpServletRequest req, HttpServletResponse res){
		checkAuth(req,res);
		return "change_pwd";
	}
	
	//执行更改密码
	@RequestMapping(value = "save_change_pwd.do")
	public String saveChangePwd(HttpServletRequest req, HttpServletResponse res, Map model){
		checkAuth(req,res);
		String message="";
		String oldPwd=req.getParameter("oldPwd");
		String newPwd=req.getParameter("newPwd");
		String newPwd2=req.getParameter("newPwd2");
		if(!newPwd.equals(newPwd2)){
			message="两次新密码不一致，请重新输入！";
		}
		else{
			CipherUtil cipher = new CipherUtil();  
			Pwd myPwd=(Pwd) pwdDao.getById(1);
			String passwordMd5=myPwd.getPwd();
			if(!cipher.validatePassword(passwordMd5, oldPwd)){
				message="原密码错误，请重新输入！";
			}
			else{
				String pwdMd5=cipher.generatePassword(newPwd);
				myPwd.setPwd(pwdMd5);
				pwdDao.update(myPwd);
				pwdDao.commit();
				message="更改密码成功！";
			}
		}
		model.put("message",message);
		return "change_pwd";
	}
}
