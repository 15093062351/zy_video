package com.zhiyou100.video.web.utils;

import org.springframework.util.DigestUtils;

public class MD5Utils {
	
public static String getMD5(String str){
		
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
	
}
