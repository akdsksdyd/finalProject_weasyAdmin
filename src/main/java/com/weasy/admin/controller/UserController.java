package com.weasy.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.service.MailService;
import com.weasy.admin.service.UserService;
import com.weasy.admin.service.UserSha256;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.PageVO;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	
	private UserService userService;
	private MailService mailservice;
	
	//management
	@GetMapping("/management")
	public String management(Model model,
			 				 Criteria cri) {
		
		ArrayList<UserVO> list = userService.managementList(cri);
		model.addAttribute("list", list);
		
		
		return "user/management";
	}
	
	//userList
	@GetMapping("/userList")
	public String userList(Model model,
						   Criteria cri) {
		
		ArrayList<UserVO> list = userService.userList(cri);
		model.addAttribute("list", list);
		
		return "user/userList";
	}
	
	//PW Reset
	@GetMapping("/pwReset/{userEmail}/{birth}")
	public String pwReset(@PathVariable("userEmail") String userEmail, 
						  @PathVariable("birth") String birth) {
		
		//PW 암호화
		String a = UserSha256.encrypt(birth);
		System.out.println(a);
		userService.pwReset(userEmail, a);
		
		//PW Reset mail발송
		mailservice.pwresetMail(userEmail, a);
		return "redirect:/user/userList";
	}
	
	//가입 승인
	@GetMapping("/permission/{userEmail}")
	public String permission(@PathVariable("userEmail") String userEmail) {
		
		//가입 승인
		userService.permission(userEmail);
		
		//가입 승인 mail발송
		mailservice.permissionMail(userEmail);
				
		return "redirect:/user/management";
	}
	
	//권한 박탈
	@GetMapping("/authority/{permission}")
	public String authority (@PathVariable("permission") String permission) {
		
		userService.authority(permission);
		
		return "redirect:/user/userList";
	};
	
	@GetMapping("/admin")
	//admin추가
	public String admin() {
		
		return "user/admin";
	}

};


