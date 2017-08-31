package com.zhiyou100.video.web.mapper;

import com.zhiyou100.video.web.model.Speaker;
import com.zhiyou100.video.web.model.SpeakerExample;
import com.zhiyou100.video.web.model.SpeakerVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpeakerMapper {
    int countByExample(SpeakerExample example);

    int deleteByExample(SpeakerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Speaker record);

    int insertSelective(Speaker record);

    List<Speaker> selectByExample(SpeakerExample example);

    Speaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByExample(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByPrimaryKeySelective(Speaker record);

    int updateByPrimaryKey(Speaker record);

	List<Speaker> fandAllSpeaker(SpeakerVo sv);

	int fandAllSpeakerCount(SpeakerVo sv);
	
	
	
	
	
	

	Speaker fandspeakerBy(Integer speakerId);
	
	
	
}