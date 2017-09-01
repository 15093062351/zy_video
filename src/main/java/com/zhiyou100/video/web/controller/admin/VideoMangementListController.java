package com.zhiyou100.video.web.controller.admin;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.web.model.Course;
import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.Video;
import com.zhiyou100.video.web.model.VideoVo;
import com.zhiyou100.video.web.service.CourseService;
import com.zhiyou100.video.web.service.SpeakerService;
import com.zhiyou100.video.web.service.VideoService;
import com.zhiyou100.video.web.utils.Page;

@Controller
@RequestMapping("/admin")
public class VideoMangementListController {
	@Autowired
	CourseService cs;
	@Autowired
	SpeakerService ss;
	@Autowired
	VideoService vs;

	@RequestMapping("/adminPage.action")
	public String adminVideomangement(
			@RequestParam(defaultValue="",required=true)String adminVideotitle,
			@RequestParam(defaultValue="",required=true)String adminSearchSperker, 
			@RequestParam(defaultValue="",required=true)String adminSearchCourse ,
			@RequestParam(defaultValue="1",required=true)Integer page
			,Model md ,HttpSession session) {
		/*
		 * 1.表单数据回显
		 * 2.page对象封装
		 */
		md.addAttribute("adminVideotitle", adminVideotitle);
		md.addAttribute("adminSearchSperker", adminSearchSperker);
		md.addAttribute("adminSearchCourse", adminSearchCourse);
		
		VideoVo vv = new VideoVo();
		vv.setAdminVideotitle(adminVideotitle);
		vv.setAdminSearchSperker(adminSearchSperker);
		vv.setAdminSearchCourse(adminSearchCourse);
		vv.setPage(page);
		vv.setBegin((page-1)*5);
		Page<Video> pages = vs.adminvideoPage(vv);
		
		
		md.addAttribute("page", pages);
		
		//System.out.println(pages.getRows());
		
		
		List<Speaker> list = ss.fandallSpeaker();
		//System.out.println(list);
		md.addAttribute("list", list);
		
		List<Course> course = cs.fandallCourse();
		md.addAttribute("course", course);
		return "/admin/videoMangement/videoMangementList";
		
	}
	
	@RequestMapping(value="/addVideo.action",method=RequestMethod.GET)
	
	public String addVideo(Model md){
		List<Speaker> list = ss.fandallSpeaker();
		
		//System.out.println(list);
		
		md.addAttribute("list", list);
		
		List<Course> course = cs.fandallCourse();
		md.addAttribute("course", course);
		
		
		return "/admin/videoMangement/addvideo";
	}
	
@RequestMapping(value="/addVideo.action",method=RequestMethod.POST)
	
	public String addVideobaocun(Video video){
	System.out.println(video.getVideoDescr());
		vs.addVideo(video);
		return "redirect:/admin/adminPage.action";
	}





@RequestMapping(value="/editVideo.action",method=RequestMethod.GET)

public String editVideo(Model md,Integer id){
	List<Speaker> list = ss.fandallSpeaker();
	
	//System.out.println(list);
	
	md.addAttribute("list", list);
	
	List<Course> course = cs.fandallCourse();
	md.addAttribute("course", course);
	//System.out.println(id+"------------------------------++++++++++++++");
	
	     Video vd  =  vs.fandVideoBy(id);
	     md.addAttribute("vd", vd);
	     
	return "/admin/videoMangement/editVideo";
}

@RequestMapping(value="/editVideo.action",method=RequestMethod.POST)

public String editVideobaocun(Video vd){

	System.out.println(vd.getVideoDescr());
	
	vs.updateVideo(vd);
	
	return "redirect:/admin/adminPage.action";
}

@RequestMapping("/deleteVideo.action")
public String deleteVideo(Integer id){
	
	vs.deleteVideoBy(id);
	
	
	return "redirect:/admin/adminPage.action";
}


@RequestMapping(value="/muiltdeleteVideo.action",method=RequestMethod.POST)
public String muiltdeleteVideo(Integer[] ids){
	
	System.out.println("666666666");
	
	System.out.println(Arrays.toString(ids));

	List<Integer> list = Arrays.asList(ids);
	
	vs.deleteVideoBycondition(list);
	
	return "redirect:/admin/adminPage.action";
}


}
