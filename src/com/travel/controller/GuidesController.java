package com.travel.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.travel.entity.*;
import com.travel.dao.GuidesDao;

@RequestMapping("/")
@Controller
public class GuidesController {
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
	
	//导游列表,按添加时间排序
	@RequestMapping(value = "guides.do")
	public String guidesOrderByTime(HttpServletRequest req, HttpServletResponse res,Map model){
		checkAuth(req,res);
		List list = (List<Guides>)guidesDao.getAll();
		model.put("guides", list);
		return "guides";
	}
	
	//导游列表,按姓名排序
	@RequestMapping(value = "guides_byname.do")
	public String guidesOrderByName(HttpServletRequest req, HttpServletResponse res,Map model){
		checkAuth(req,res);
		List list = guidesDao.getAllByName();
		model.put("guides", list);
		return "guides";
	}
	
	//进入增加导游页面
	@RequestMapping(value = "add_guide.do")
	public String addLine(HttpServletRequest req, HttpServletResponse res,Map model){
		checkAuth(req,res);
		Guides guide=new Guides();
		guidesDao.save(guide);
		model.put("guide", guide);
		return "update_guide";
	}
	
	//进入更新导游信息页面
	@RequestMapping(value = "update_guide_{id}.do")
	public String updateGuide(@PathVariable int id, HttpServletRequest req, HttpServletResponse res,Map model){
		checkAuth(req,res);
		Guides guide=(Guides) guidesDao.getById(id);
		model.put("guide", guide);
		return "update_guide";
	}
	
	//更新导游信息
	@RequestMapping(value = "save_guide_{id}.do")
	public String saveUpdateGuide(@PathVariable int id, Map model, Guides guide,HttpServletRequest req, HttpServletResponse res){
		checkAuth(req,res);
		guide.setId(id);
		guidesDao.update(guide);
		guidesDao.commit();
		model.put("guide", guide);
		return "update_guide";
	}
	
	//删除一个导游
	@RequestMapping(value = "delete_guide_{id}.do")
	public void deleteGuide(@PathVariable int id,HttpServletRequest req, HttpServletResponse res){
		checkAuth(req,res);
		guidesDao.deleteById(id);
		guidesDao.commit();
	}
	
	//前台导游列表
	@RequestMapping(value = "front_guides.do")
	public String frontGuides(Map model){
		List list = guidesDao.getAllByName();
		model.put("guides", list);
		return "front_guides";
	}
	
	//导游介绍详细页
	@RequestMapping(value = "front_guide_{id}.do")
	public String lineDetail(@PathVariable int id, Map model){
		Guides guide=(Guides) guidesDao.getById(id);
		model.put("guide", guide);
		return "front_guide_detail";
	}
	
	//按姓名模糊搜索
	@RequestMapping(value = "serch_name.do")
	public String serchByName(HttpServletRequest req, Map model){
		String name=req.getParameter("name");
		List guides=null;
		//如果用户没有输入任何名字
		if(name==null)
		{
			name="";
			guides = guidesDao.getAllByName();
		}
		else{
			guides = guidesDao.getByName(name);
		}
		model.put("guides", guides);
		return "front_guides";
	}
	
}
