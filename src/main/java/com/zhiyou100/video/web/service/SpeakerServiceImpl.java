package com.zhiyou100.video.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.web.mapper.SpeakerMapper;
import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.SpeakerVo;
import com.zhiyou100.video.web.utils.Page;

@Service
public class SpeakerServiceImpl implements SpeakerService {
	@Autowired
	SpeakerMapper sm;

	@Override
	public List<Speaker> fandallSpeaker() {
		
		
		return sm.selectByExample(null);
	}

	@Override
	public Page<Speaker> adminSpeakerPage(SpeakerVo sv) {
		Page<Speaker> page = new Page<>();
		page.setPage(sv.getPage());
		page.setSize(5);
		page.setRows(sm.fandAllSpeaker(sv));
		page.setTotal(sm.fandAllSpeakerCount(sv));
		
		System.out.println(sm.fandAllSpeakerCount(sv));
		System.out.println(sm.fandAllSpeaker(sv));
		return page;
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		
		sm.insertSelective(speaker);
	}

	@Override
	public Speaker fandSpeakerBy(Integer id) {
		
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		
		sm.updateByPrimaryKeySelective(speaker);
		
	}

	@Override
	public void deleteSpeakerBy(Integer id) {
		
		sm.deleteByPrimaryKey(id);
		
	}
}
