package com.zhiyou100.video.web.service;

import java.util.List;

import com.zhiyou100.video.web.model.Course;
import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.Subject;
import com.zhiyou100.video.web.model.Video;

public interface FrontCourseService {

	List<Course> fandallCourse();




	List<Subject> fandSubject();




	Video fandvideoBy(Integer videoId);




	Speaker fandspeaker(Integer speakerId);




	Course fandcourseBy(Integer courseId);




	List<Video> fandVideoList(Integer courseId);

	

	

	
	
	
	
	
	
	
}
