package com.zhiyou100.video.web.controller.front;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.web.model.User;
import com.zhiyou100.video.web.service.UserService;
import com.zhiyou100.video.web.utils.MailUtil;

@Controller
@RequestMapping("/front")
public class FrontIndexController {
	
	@Autowired
	UserService us ;
	
	@RequestMapping("/index.action")
	
	public String index(){
	
		return "/front/index";
		
	}
	/*@RequestMapping("/user/logout.action")
	public String logout(){
		
		
		return "redirect:/front/user/index.action";
	}*/
	
	@ResponseBody
	@RequestMapping(value="/user/login.action",method=RequestMethod.POST)
	public String login(User u ,HttpSession session){
		List<User> list = us.fandUser(u);	
		//System.out.println(list);
		String str =null;
		if(list.isEmpty()){ 
			return str;
		}else {
			str="success";	
			User user = list.get(0);
			
			session.setAttribute("uid", user.getId());
			
			session.setAttribute("user", user);
			return str;
		}
	}
	
	@RequestMapping(value="/user/forgetpwd.action",method=RequestMethod.GET)
	public String forgetpwd(){
		
		
		
		return "/front/user/forget_pwd";
	}
	
	@RequestMapping(value="/user/forgetpwd.action",method=RequestMethod.POST)
	public String pwdsubmit(String captcha,String email,Model md){
		//System.out.println(captcha);
		User user = us.fanduserBy(email);
		
		
		String str = null;
		if(user.getCaptcha().equals(captcha)){
			str="/front/user/reset_pwd";
			md.addAttribute("user", user);
		}else{
			str="/front/user/forget_pwd";
		}
		return str;
	}
	
	@RequestMapping(value="/user/resetpwd.action",method=RequestMethod.POST )
	public String updatemima(User u,Model md){
		System.out.println(u.getId());
		us.updatepwd(u);
		
		
		return "redirect:/front/index.action";
	}
	@ResponseBody
	@RequestMapping(value="/user/sendemail.action",method=RequestMethod.POST)
	public String forgetsubmit(String email) throws Exception{
		//System.out.println(email);
		//md.addAttribute("user", email);
		Random ran = new Random();
		int a = ran.nextInt(9000)+1000;
		
		User user = us.fanduserBy(email);
		
		user.setCaptcha(""+a);
		
		us.updateUserBy(user);
		
		MailUtil.send(email, "获取验证码", ""+a);
		
		return "success";
	}
	
	@RequestMapping(value="/user/regist.action",method=RequestMethod.POST)
	@ResponseBody
	public String regist(User u,String email){
		
		List<User> list = us.findUserByName(email);
		
		if(list.isEmpty()){
			
			us.addUser(u);
			return "success"; 
		}else {
			
			return "faile";
		}
	}
	
	@RequestMapping("/user/index.action")
	public String Userindex(){
		
		
		
		
		//System.out.println("9999999999999999999999");
		
		return "/front/user/index";
	}
	
	@RequestMapping(value="/user/profile.action",method=RequestMethod.GET)
	public String profile(Integer id,Model md){
		//System.out.println(id);
		
  		User u = us.fanduserBy(id);
  		
  		md.addAttribute("user", u);
	
		//System.out.println(u+"---------------------"+id);
		
	return "/front/user/profile";
	} 
	
	@RequestMapping(value="/user/profile.action",method=RequestMethod.POST)
	public String profilesubmit(User u){
		
		 us.updateUserBy(u);
		
		
		return "redirect:/front/user/index.action";
	}
	
    @RequestMapping(value="/user/avatar.action",method=RequestMethod.GET)
	public String avatar(Integer id,Model md){
    	
    	System.out.println(id);
    	User u = us.fanduserBy(id);
    	md.addAttribute("user", u);
    	
	return "/front/user/avatar";
	
	}
    @RequestMapping(value="/user/avatar.action",method=RequestMethod.POST)
    public String avatarsubmit(User uu,HttpSession session,MultipartFile pic,Model md) throws Exception{
    	/*
    	 * 定义文件的储存名字,唯一不重复,UUID.产生随机数
    	 */
    	String str = UUID.randomUUID().toString().replaceAll("-", "");
    	/*
    	 * 获取扩展名---------jpg
    	 */
    	String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
    	/*
    	 * 起名字结束
    	 */
    	String strr =str+"."+extension;
        
        //uu.setuPic(strr);
    	uu.setHeadUrl(strr);
        
    	System.out.println(uu);
        us.updatePic(uu);
        
        User user = us.fanduserBy(uu.getId());
        
        md.addAttribute("user", user);
        
       // System.out.println(uu);
       // System.out.println(uu.getuPic());
        
        String  path ="D:\\upload";
        
        pic.transferTo(new File(path+"\\"+strr));
    
     // System.out.println(uu);
     // System.out.println((User)session.getAttribute("user"));
        
    return "/front/user/index";
    	
    }
	@RequestMapping("/user/password.action")
	public String password(User uu,Model md){
		User user = us.fanduserBy(uu.getId());
		md.addAttribute("user", user);
	//	System.out.println(uu.getId());
		
		return "/front/user/password";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/user/spassword.action",method=RequestMethod.POST)
	public String passwordAjax(String oldPassword,User uu,HttpSession session){
		
		    int a = (int) session.getAttribute("uid");
		    User user =  us.fandUserBY(a);
		    
		    String str= DigestUtils.md5DigestAsHex(oldPassword.getBytes());
		    String strr = null ;
			if(str.equals(user.getPassword())){
				strr="success";
		    }else{
		    	strr="faile";
		    }
		    System.out.println(user);
		  return strr;
	}
	
	@RequestMapping(value="/user/password.action",method=RequestMethod.POST)
	public String pwdsubmit (String newPassword,HttpSession session){
		 int a = (int) session.getAttribute("uid");
		 User user =  us.fandUserBY(a);
		user.setPassword(newPassword);
		us.updatepwd(user);
		
		return "redirect:/front/index.action";
	}
	
	@RequestMapping("/user/logout.action")
	public String logout(){
		
		
		return "redirect:/front/index.action";
	}
	
	
	
	
	
	
}
