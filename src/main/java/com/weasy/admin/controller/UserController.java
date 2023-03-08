package com.weasy.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String management(HttpSession session,
						     Model model,
						     Criteria cri) {
		
		//로그인 한 회원만 조회
		String userId = (String)session.getAttribute("userId");

		ArrayList<UserVO> list = userService.getList(userId, cri);
		model.addAttribute("list", list);
		
		//페이지네이션 처리
		int total = userService.getTotal(userId, cri);
		PageVO pageVO = new PageVO(cri, total);
		model.addAttribute("pageVO", pageVO);
		
		return "user/management";
	}
	
	@GetMapping("/userList")
	public String userList(HttpSession session,
						   Model model,
						   Criteria cri) {
		
		//로그인 한 회원만 조회
		String userId = (String)session.getAttribute("userId");
		
		ArrayList<UserVO> list = userService.getList(userId, cri);
		model.addAttribute("list", list);
		
		return "user/userList";
	}

}
