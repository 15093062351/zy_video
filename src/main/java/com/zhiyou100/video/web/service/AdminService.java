package com.zhiyou100.video.web.service;

import java.util.List;

import com.zhiyou100.video.web.model.Admins;

public interface AdminService {

	List<Admins> admin(String loginName, String loginPwd);

	
	
	
}
