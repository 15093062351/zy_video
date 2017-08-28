package com.zhiyou100.video.web.model;

public class SpeakerVo {
	
	private String speakerName;
	private String speakerJob;
	private int page;
	private int begin;
	private Speaker speaker;
	
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getSpeakerJob() {
		return speakerJob;
	}
	public void setSpeakerJob(String speakerJob) {
		this.speakerJob = speakerJob;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	@Override
	public String toString() {
		return "SpeakerVo [speakerName=" + speakerName + ", speakerJob=" + speakerJob + ", page=" + page + ", begin="
				+ begin + ", speaker=" + speaker + "]";
	}
	
	
}
