package com.zhiyou100.video.web.service;

import java.util.List;

import com.zhiyou100.video.web.model.Video;
import com.zhiyou100.video.web.model.VideoVo;
import com.zhiyou100.video.web.utils.Page;

public interface VideoService {

	Page<Video> adminvideoPage(VideoVo vv);

	void addVideo(Video video);

	Video fandVideoBy(Integer id);

	void updateVideo(Video vd);

	void deleteVideoBy(Integer id);

	void deleteVideoBycondition(List<Integer> list);

	List<Video> findAvgCount();

	

}
