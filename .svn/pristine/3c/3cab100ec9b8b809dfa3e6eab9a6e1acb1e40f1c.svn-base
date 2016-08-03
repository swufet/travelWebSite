package com.travel.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/")
@Controller
public class UploadController {
	
	@RequestMapping(value = "/uploadImg.do")
	 public String uploadImg(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
		 
        String path = request.getSession().getServletContext().getRealPath("upload");
        
        Date now = new Date();
		// 判断"类型"路径是否存在，不存在则创建
		File dir = new File(path);
		if (!dir.isDirectory())
			dir.mkdir();
		// 判断"年月"路径是否存在，不存在则创建
		path += "/" + new SimpleDateFormat("yyyyMM").format(now);
		dir = new File(path);
		if (!dir.isDirectory())
			dir.mkdir();
		// 判断"日"路径是否存在，不存在则创建
		path += "/" + new SimpleDateFormat("dd").format(now);
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
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+realFileName);  
        return "show";  
    }  
}  

