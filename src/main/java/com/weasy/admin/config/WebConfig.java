package com.weasy.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.weasy.admin.util.interceptor.AddAdminHandler;
import com.weasy.admin.util.interceptor.UserAuthHandler;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	// 로그인
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}
	
	// 관리자 등록 화면 권한 검사
	@Bean
	public AddAdminHandler addAdminHandler() {
		return new AddAdminHandler();
	}
	
	// WebMvcConfigurer 클래스가 제공해주는 인터셉터 추가 함수
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 프리핸들러  
		// 인터셉터 + 가로챌 경로 추가
		registry.addInterceptor(userAuthHandler())
		.addPathPatterns("/board/*")
		.addPathPatterns("/user/management")
		.addPathPatterns("/user/userList")
		.addPathPatterns("/team/*")
		.addPathPatterns("/notice/*"); 
		
		// 관리자 권한 검사
		registry.addInterceptor(addAdminHandler())
		.addPathPatterns("/user/admin");
		
	}

}
