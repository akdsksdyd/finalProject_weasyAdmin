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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.service.UserService;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.PageVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/management")
	public String management(Model model,
			 				@RequestParam(value = "permission",required=false) String permission ,
			 				Criteria cri) {
		
		ArrayList<UserVO> list = userService.managementList(cri);
		model.addAttribute("list", list);
		
		System.out.println("실행");
		
		return "user/management";
	}
	
	@GetMapping("/userList")
	public String userList(Model model,
						   Criteria cri) {
		
		ArrayList<UserVO> list = userService.userList(cri);
		model.addAttribute("list", list);
		return "user/userList";
	}
	

	
};


