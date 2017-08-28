package com.zhiyou100.video.web.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.video.web.model.VideoVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class VideoMapperTest {

	@Autowired
	VideoMapper vm;
	@Test
	public void test() {
		VideoVo vv = new VideoVo();
		vv.setAdminSearchCourse("8");
		vv.setAdminSearchSperker("8");
		vv.setBegin(1);
		System.out.println(vm.fandallVideo(vv)+"----------"+vm.fandallVideoCount(vv));
	}

}
