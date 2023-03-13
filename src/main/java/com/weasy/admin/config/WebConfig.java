package com.weasy.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.weasy.admin.util.interceptor.UserAuthHandler;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	// 프리핸들러 - 컨트롤러 진입 전 실행
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}

	// WebMvcConfigurer 클래스가 제공해주는 인터셉터 추가 함수
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 프리핸들러  
		// 인터셉터 + 가로챌 경로 추가
		registry.addInterceptor(userAuthHandler())
		.addPathPatterns("/board/*")
		.addPathPatterns("/user/*")
		.addPathPatterns("/team/*"); 

	}

}
