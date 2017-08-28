package com.zhiyou100.video.web.model;

public class VideoVo {

	private String adminVideotitle;
	private String adminSearchSperker;
	private String adminSearchCourse;
	private int page;
	private int begin;
	private Video video;
	
	
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getAdminSearchSperker() {
		return adminSearchSperker;
	}
	public void setAdminSearchSperker(String adminSearchSperker) {
		this.adminSearchSperker = adminSearchSperker;
	}
	public String getAdminSearchCourse() {
		return adminSearchCourse;
	}
	public void setAdminSearchCourse(String adminSearchCourse) {
		this.adminSearchCourse = adminSearchCourse;
	}
	public String getAdminVideotitle() {
		return adminVideotitle;
	}
	public void setAdminVideotitle(String adminVideotitle) {
		this.adminVideotitle = adminVideotitle;
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
		return "VideoVo [adminVideotitle=" + adminVideotitle + ", adminSearchSperker=" + adminSearchSperker
				+ ", adminSearchCourse=" + adminSearchCourse + ", page=" + page + ", begin=" + begin + ", video="
				+ video + "]";
	}
	
	
	
	
	
	
	
	
}
