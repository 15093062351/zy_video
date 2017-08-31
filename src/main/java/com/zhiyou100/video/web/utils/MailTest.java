package com.zhiyou100.video.web.utils;

import org.junit.Test;

public class MailTest {

	@Test
	public void test01 () throws Exception{
		
		MailUtil.send("536417254@qq.com", "节日祝福", "Happy valentine's day");
	}
	
}
