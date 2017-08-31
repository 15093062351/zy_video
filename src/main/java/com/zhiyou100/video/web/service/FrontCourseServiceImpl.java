package com.zhiyou100.video.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.web.mapper.CourseMapper;
import com.zhiyou100.video.web.mapper.SpeakerMapper;
import com.zhiyou100.video.web.mapper.SubjectMapper;
import com.zhiyou100.video.web.mapper.VideoMapper;
import com.zhiyou100.video.web.model.Course;
import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.Subject;
import com.zhiyou100.video.web.model.Video;

@Service
public class FrontCourseServiceImpl implements FrontCourseService {
	
	@Autowired 
	VideoMapper vm;
	@Autowired 
	CourseMapper cm;
	@Autowired
	SubjectMapper sm ;
	@Autowired
	SpeakerMapper skm;
	
	@Override
	public List<Course> fandallCourse() {
		
		
		
		return cm.fandallcourse();
	}


	@Override
	public List<Subject> fandSubject() {
		
		
		return sm.fandallsubject();
	}


	@Override
	public Video fandvideoBy(Integer videoId) {
		
		
		
		return vm.fandVideoBy(videoId);
	}


	@Override
	public Speaker fandspeaker(Integer speakerId) {
		return skm.fandspeakerBy(speakerId);
	}


	@Override
	public Course fandcourseBy(Integer courseId) {
		// TODO Auto-generated method stub
		return cm.fandcoursebyid(courseId);
	}


	@Override
	public List<Video> fandVideoList(Integer courseId) {
		// TODO Auto-generated method stub
		return vm.fandallVideoBy(courseId);
	}


	

	
	
	

}
