package com.weasy.admin.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AddAdminHandler implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("role") == null) {
			// 로그인 페이지에서 온 요청은 로그인 페이지로 리디렉션
			response.sendRedirect("/");
		}else if((int)request.getSession().getAttribute("role") == 1) {
			
			// 요청이 들어왔던 위치로 리디렉션
			response.sendRedirect(request.getHeader("Referer"));
			return false;
		}
		
		return true;
	}
}
