package com.weasy.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weasy.admin.service.UserService;

@Controller
public class UserAjaxController {
	
	@Autowired
	private UserService userService;
	
		//이메일 중복검사
		@ResponseBody
		@PostMapping("/idCheck")
		public int idCheck(@RequestParam("id") String id) {
			
			int cnt = userService.idCheck(id);
			
			return cnt;
			
		}

}
