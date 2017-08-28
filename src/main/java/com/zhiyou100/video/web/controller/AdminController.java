package com.zhiyou100.video.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.video.web.model.Admins;
import com.zhiyou100.video.web.service.AdminService;
@Controller
@RequestMapping("/video")
public class AdminController {
	@Autowired
	AdminService as;
@RequestMapping(value="/admin.action",method=RequestMethod.GET)	
	public String admin(){
		
		
		return "/admin";
	}
@RequestMapping(value="/admin.action",method=RequestMethod.POST)	
public String Admin(String loginName, String loginPwd,HttpSession session){
	
	List<Admins> list = as.admin(loginName,loginPwd);
	String str = null ;
	if(list.isEmpty()){
		str="/admin";
		
	}else{
		
		/*session.setAttribute("list", list);*/
		str="redirect:/admin/adminPage.action";
	}
	return str;
}






















}
