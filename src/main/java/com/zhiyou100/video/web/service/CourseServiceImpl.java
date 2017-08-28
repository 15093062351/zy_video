package com.zhiyou100.video.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.web.mapper.CourseMapper;
import com.zhiyou100.video.web.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
	CourseMapper cm ;

	@Override
	public List<Course> fandallCourse() {
		
		
		return cm.selectByExample(null);
	}

	@Override
	public List<Course> fandAllCourse() {
		
		
		
		return cm.fandCourse();
	}
}
