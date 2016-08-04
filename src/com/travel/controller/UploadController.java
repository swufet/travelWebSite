package com.travel.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/")
@Controller
public class UploadController {
	
//	@Autowired
//	CarsDao carsDao;

	
	@RequestMapping(value = "/uploadImg.do")
	 public void uploadImg(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req, HttpServletResponse res) {  
		res.setContentType("text/html;charset=UTF-8"); 
		String path = req.getSession().getServletContext().getRealPath("upload");
		HttpSession session=req.getSession();
        Date now = new Date();
		// 判断"类型"路径是否存在，不存在则创建
		File dir = new File(path);
		if (!dir.isDirectory())
			dir.mkdir();
		// 判断"年月"路径是否存在，不存在则创建
		String nowMonth=new SimpleDateFormat("yyyyMM").format(now);
		path += "/" + nowMonth;
		dir = new File(path);
		if (!dir.isDirectory())
			dir.mkdir();
		// 判断"日"路径是否存在，不存在则创建
		String nowDay=new SimpleDateFormat("dd").format(now);
		path += "/" + nowDay; 
		dir = new File(path);
		if (!dir.isDirectory())
			dir.mkdir();
        String fileName = file.getOriginalFilename();
        int pointIndex=fileName.lastIndexOf('.');
        String fileType=fileName.substring(pointIndex, fileName.length());
        String realFileName = UUID.randomUUID().toString()+fileType;
        File targetFile = new File(dir, realFileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        
        
        /*图片的相对地址*/
        String imageUrl="upload/"+nowMonth+"/"+nowDay+"/"+realFileName;
        
        //return imageUrl;
        try {
			res.getWriter().print(imageUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
        //req.getSession().setAttribute("fileUrl", targetFile.getAbsolutePath());
    }  
}  

