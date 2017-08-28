package com.zhiyou100.video.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.web.mapper.VideoMapper;
import com.zhiyou100.video.web.model.Video;
import com.zhiyou100.video.web.model.VideoExample;
import com.zhiyou100.video.web.model.VideoVo;
import com.zhiyou100.video.web.utils.Page;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
	VideoMapper vm ;

	@Override
	public Page<Video> adminvideoPage(VideoVo vv) {
		
		Page<Video> page = new Page <> ();
		page.setPage(vv.getPage());
		page.setSize(5);
		page.setTotal(vm.fandallVideoCount(vv));
		page.setRows(vm.fandallVideo(vv));
		
		//System.out.println(vm.fandallVideo(vv)+"------"+vm.fandallVideoCount(vv));
		
		return page;
	}

	@Override
	public void addVideo(Video video) {
		
		vm.insertSelective(video);
		
		
	}

	@Override
	public Video fandVideoBy(Integer id) {
		
		return vm.selectByPrimaryKey(id);
	}

	@Override
	public void updateVideo(Video vd) {
		
		System.out.println(vd);
		
		vm.updateByPrimaryKeySelective(vd);
	}

	@Override
	public void deleteVideoBy(Integer id) {
		
		vm.deleteByPrimaryKey(id);
		
	}

	@Override
	public void deleteVideoBycondition(List<Integer> list) {
		VideoExample ve = new VideoExample ();
		
		ve.createCriteria().andIdIn(list);
		
		vm.deleteByExample(ve);
		
		
	}

	@Override
	public List<Video> findAvgCount() {
		
		
		return vm.findAvgCount();
	}

	
	
	
	
}
