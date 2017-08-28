package com.zhiyou100.video.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zhiyou100.video.web.mapper.AdminsMapper;
import com.zhiyou100.video.web.model.Admins;
import com.zhiyou100.video.web.model.AdminsExample;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired
AdminsMapper am;
@Override
public List<Admins> admin(String loginName, String loginPwd) {
	
	String str = DigestUtils.md5DigestAsHex(loginPwd.getBytes());
	/*System.out.println(str);*/
	AdminsExample  ae = new AdminsExample();
	ae.createCriteria().andLoginNameEqualTo(loginName).andLoginPwdEqualTo(str);
	am.selectByExample(ae);
	return am.selectByExample(ae);
}
	
	
	
	
	
	
}
