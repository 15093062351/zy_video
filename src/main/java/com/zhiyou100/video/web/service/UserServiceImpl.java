package com.zhiyou100.video.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zhiyou100.video.web.mapper.UserMapper;
import com.zhiyou100.video.web.model.User;
import com.zhiyou100.video.web.model.UserExample;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper um;

	@Override
	public void addUser(User u) {
		String str= DigestUtils.md5DigestAsHex(u.getPassword().getBytes());
		
		u.setPassword(str);
		um.insertSelective(u);

	}

	
	@Override
	public List<User> fandUser(User u) {
        
		String str= DigestUtils.md5DigestAsHex(u.getPassword().getBytes());
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(str);
		List<User> list = um.selectByExample(ue);
		return list;
		
	}


	@Override
	public List<User> findUserByName(String email) {
		UserExample ue = new UserExample();
		
		ue.createCriteria().andEmailEqualTo(email);
		List<User> list = um.selectByExample(ue);
		return list;
	}


	@Override
	public User fanduserBy(Integer id) {
		
		
		return um.selectByPrimaryKey(id);
	}


	@Override
	public void updateUserBy(User u) {
		
		um.updateByPrimaryKeySelective(u);
		
	}


	@Override
	public void updatePic(User uu) {
		
		um.updateByPrimaryKeySelective(uu);
		
	}


	@Override
	public User fanduserBy(String email) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		List<User> list = um.selectByExample(ue);
		User user = list.get(0);
		return user;
	}


	@Override
	public User fandUserBY(String captcha) {
		UserExample ue = new UserExample();
		ue.createCriteria().andCaptchaEqualTo(captcha);
		List<User> list = um.selectByExample(ue);
		User user = list.get(0);
		
		return user;
	}


	@Override
	public void updatepwd(User u) {
String str= DigestUtils.md5DigestAsHex(u.getPassword().getBytes());
		
		u.setPassword(str);
		
		um.updateByPrimaryKeySelective(u);
	}


	@Override
	public User fandUserBY(int a) {
		
		
		return um.selectByPrimaryKey(a);
	}


	




	
	
}
