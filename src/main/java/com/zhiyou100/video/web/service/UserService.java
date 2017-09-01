package com.zhiyou100.video.web.service;

import java.util.List;

import com.zhiyou100.video.web.model.User;

public interface UserService {

	void addUser(User u);
	List<User> fandUser(User u);
	List<User> findUserByName(String email);
	User fanduserBy(Integer id);
	void updatePic(User uu);
	User fanduserBy(String email);
	void updateUserBy(User u);
	User fandUserBY(String captcha);
	void updatepwd(User u);
	User fandUserBY(int a);


}
