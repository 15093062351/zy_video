package com.zhiyou100.video.web.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.web.model.Course;
import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.Subject;
import com.zhiyou100.video.web.model.Video;
import com.zhiyou100.video.web.service.FrontCourseService;

@Controller
@RequestMapping("/front")
public class FrontCourseController {
	
	@Autowired
	FrontCourseService fcs;
	
	
	@RequestMapping("course/index.action")
	public String index(Model md,Integer subjectId){
     List<Course> course =  fcs.fandallCourse();
	 md.addAttribute("course",course);
	 
	 
	 List<Subject> list = fcs.fandSubject();
	  Subject subject = list.get(0);
	 md.addAttribute("subject", subject);
	 md.addAttribute("subjectId", subjectId);
		return "/front/course/index";
	}
	
	
	
	
	
	@RequestMapping("video/index.action")
	public String video(Integer subjectId,Model md,Integer videoId){
		 List<Subject> list = fcs.fandSubject();
		 Subject subject = list.get(0);
		 md.addAttribute("subject", subject);
		 md.addAttribute("subjectId", subjectId);
		 md.addAttribute("videoId", videoId);
		 
		 
		 
		 
		return "/front/video/index";
	}
	
	
	
	
	@RequestMapping("video/videoData.action")
	public String videoData(Model md,Integer videoId){
		
	    Video video = fcs.fandvideoBy(videoId);
	    md.addAttribute("video", video);	    
	  // Integer videolength = video.getVideoLength();
	   
	   /*int temp=0;
       StringBuffer sb=new StringBuffer();
       sb.append(videolength/3600+":");
    
       temp=videolength%3600/60;
       sb.append((temp<10)?"0"+temp+":":""+temp+":");
    
       temp=videolength%3600%60;
       sb.append((temp<10)?"0"+temp:""+temp);
    
          sb.toString();*/
	    
	    
	    
	    
	   
	   
	   
	   
	    Integer speakerId = video.getSpeakerId();
	    Speaker speaker = fcs.fandspeaker(speakerId);
	    md.addAttribute("speaker", speaker);
	    
	    Integer courseId = video.getCourseId();
	    Course course = fcs.fandcourseBy(courseId);
	    md.addAttribute("course", course);	    
	    List<Video> videolist = fcs.fandVideoList(courseId);
	    md.addAttribute("videoList", videolist);
	    
		return "/front/video/content";
	}
	
	
	
	
	
    @RequestMapping("video/state.action")
	public String videostate(Integer videoId,Model m){
    	/*Video video = fcs.fandvideoBy(videoId);
    	System.out.println(video);
		m.addAttribute("videoId", videoId);
		m.addAttribute("video", video);*/
		
		return "/front/video/content";
		
	}
	
	
	
    
  /*  public static String change(int seconds)
    {
        int temp=0;
        StringBuffer sb=new StringBuffer();
        sb.append(seconds/3600+":");
     
        temp=seconds%3600/60;
        sb.append((temp<10)?"0"+temp+":":""+temp+":");
     
        temp=seconds%3600%60;
        sb.append((temp<10)?"0"+temp:""+temp);
     
        return sb.toString();
    }*/
	
	
	
	
}
