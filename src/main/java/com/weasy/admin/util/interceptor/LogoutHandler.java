package com.weasy.admin.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LogoutHandler implements HandlerInterceptor{
	
	// 로그아웃 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 세션값 제거
		request.getSession().removeAttribute("user_id");
		request.getSession().removeAttribute("role");
		// 로그인 페이지로 리디렉션
		response.sendRedirect(request.getContextPath() + "/"); 
		
		return false;
	}
}
