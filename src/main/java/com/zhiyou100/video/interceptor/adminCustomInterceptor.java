package com.zhiyou100.video.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class adminCustomInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		 List list = (List) req.getSession().getAttribute("list");
		if(list==null){
			System.out.println(6666);
			res.sendRedirect(req.getContextPath()+"/admin/admin.action");
			return false;
		}
		return true;
}
}



