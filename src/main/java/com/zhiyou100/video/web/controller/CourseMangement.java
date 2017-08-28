package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.web.model.Course;
import com.zhiyou100.video.web.service.CourseService;

@Controller
@RequestMapping("/admin")
public class CourseMangement {

	@Autowired
	CourseService cs;
	
	
	
	@RequestMapping("/courseList.action")
	public String courseMangement(Model md){
		
		 
	 List<Course>  c  =  cs.fandAllCourse();
	 System.out.println(c);
		md.addAttribute("c", c);
		
		return "/courseMangement/courseList";
	}
}
