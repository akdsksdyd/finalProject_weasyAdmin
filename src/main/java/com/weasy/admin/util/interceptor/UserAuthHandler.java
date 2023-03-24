package com.weasy.admin.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthHandler implements HandlerInterceptor{
	
	// 모든 경로에 대한 로그인 체크
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {
		
		// 현재 세션을 얻음
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		if(user_id == null) { // 로그인 안됨
			// 로그인 페이지로 리디렉션
			response.sendRedirect(request.getContextPath() + "/"); 
			return false; // 컨트롤러를 실행하지 않음
		}
		
		return true; // 컨트롤러 실행
	}
		
}
