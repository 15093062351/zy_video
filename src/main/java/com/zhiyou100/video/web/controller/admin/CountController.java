package com.zhiyou100.video.web.controller.admin;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou100.video.web.model.Video;
import com.zhiyou100.video.web.model.View;
import com.zhiyou100.video.web.service.VideoService;
@RequestMapping("admin")
@Controller
public class CountController {


	@Autowired
	VideoService vs;
	@RequestMapping("/countMangement.action")
	public String countList(){
		
		
		
		
		
		return "/admin/count/countMangement";
	}
	
	
@RequestMapping("/countMangemente.action")
	
	@ResponseBody
	public String countList(Model md) throws Exception{
		
		List<Video> vlist = vs.findAvgCount();
		
		List  li = new LinkedList();
		
		for (Video v: vlist){
			
			View vi = new View ();
			vi.setId(v.getVideoPlayTimes());

			vi.setName(v.getCourseName());
			li.add(vi);
		}
		
		ObjectMapper mapper = new ObjectMapper();    
		String json = mapper.writeValueAsString(li); 
		return json;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
