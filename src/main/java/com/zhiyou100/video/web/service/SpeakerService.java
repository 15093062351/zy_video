package com.zhiyou100.video.web.service;

import java.util.List;

import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.SpeakerVo;
import com.zhiyou100.video.web.utils.Page;

public interface SpeakerService {

	List<Speaker> fandallSpeaker();

	Page<Speaker> adminSpeakerPage(SpeakerVo sv);

	void addSpeaker(Speaker speaker);

	Speaker fandSpeakerBy(Integer id);

	void updateSpeaker(Speaker speaker);

	void deleteSpeakerBy(Integer id);

	

}
