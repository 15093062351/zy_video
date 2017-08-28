package com.zhiyou100.video.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.SpeakerVo;
import com.zhiyou100.video.web.service.SpeakerService;
import com.zhiyou100.video.web.utils.Page;

@Controller
@RequestMapping("/admin")
public class ListOfSpeakerController {

	@Autowired
	SpeakerService ss;
	
	
    @RequestMapping("/speakerList.action")	
	public String SpeakerList(
			@RequestParam(defaultValue="",required=true)String speakerName,
			@RequestParam(defaultValue="",required=true)String speakerJob, 
			@RequestParam(defaultValue="1",required=true)Integer page
			,Model md){
    	/*
		 * 1.表单数据回显
		 * 2.page对象封装
		 */
    	md.addAttribute("speakerName", speakerName);
		md.addAttribute("speakerJob", speakerJob);
		
		SpeakerVo sv = new SpeakerVo();
		sv.setPage(page);
		sv.setSpeakerJob(speakerJob);
		sv.setSpeakerName(speakerName);
		sv.setBegin((page-1)*5);
		
		Page<Speaker> pages = ss.adminSpeakerPage(sv);
		
    	md.addAttribute("page", pages);
		return "/listOfSpeaker/speakerList";
	}
    
    @RequestMapping(value="/addSpeaker.action",method=RequestMethod.GET)
    public String addSpeaker(){
    	
    	
    	
    	
		return "/listOfSpeaker/addSpeaker";
    	
    }
    @RequestMapping(value="/addSpeaker.action",method=RequestMethod.POST)
    public String addSpeakerbaocun(Speaker speaker){
    	System.out.println("8888888888888888888");
    	System.out.println(speaker.getSpeakerName());
    	
    	
    	ss.addSpeaker(speaker);
    	
    	
    	return "redirect:/admin/speakerList.action";
    }
    
   
    
    @RequestMapping(value="/editSpeaker.action",method=RequestMethod.GET)
    public String editSpeaker(Integer id,Model md){
    	
    	      Speaker s  = ss.fandSpeakerBy(id);
    	      md.addAttribute("s", s);
    	      
		return "/listOfSpeaker/editSpeaker";
    }
    @RequestMapping(value="/editSpeaker.action",method=RequestMethod.POST)
    public String editSpeakerbaocun(Speaker speaker){
    	
    	//System.out.println(speaker.getSpeakerJob());
    	
    	ss.updateSpeaker(speaker);
    	
    	
    	return "redirect:/admin/speakerList.action";
    }
    
    @RequestMapping("/deleteSpeaker.action")
    public String deleteSpeaker(Integer id){
    	
    	ss.deleteSpeakerBy(id);
    	
    	return "redirect:/admin/speakerList.action";
    }
}
