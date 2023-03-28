package com.weasy.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weasy.admin.command.AdminVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.service.MailService;
import com.weasy.admin.service.UserService;
import com.weasy.admin.service.UserSha256;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.UserCriteria;
import com.weasy.admin.util.UserPageVO;

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
							 UserCriteria cri) {

		ArrayList<UserVO> list = userService.managementList(cri);
		model.addAttribute("list", list);

		//System.out.println(list.size());

		//페이지네이션
		int total = userService.getTotal(cri);
		UserPageVO pageVO = new UserPageVO(cri,total);
		
		//System.out.println(pageVO.toString());
		
		model.addAttribute("pageVO", pageVO);
		
		return "user/management";
	}

	//userList
	@GetMapping("/userList")
	public String userList(Model model,
						   UserCriteria cri) {

		ArrayList<UserVO> list = userService.userList(cri);
		model.addAttribute("list", list);
		
		//System.out.println(cri.toString());
		
		//페이지네이션
		int total2 = userService.getTotal2(cri);
		UserPageVO pageVO2 = new UserPageVO(cri,total2);
		
		model.addAttribute("pageVO", pageVO2);

		return "user/userList";
	}

	//pwReset
	@GetMapping("/pwReset/{userEmail}/{birth}")
	public String pwReset(@PathVariable("userEmail") String userEmail, 
						  @PathVariable("birth") String birth) {

		//pw암호화
		String a = UserSha256.encrypt(birth);
		//System.out.println(a);
		userService.pwReset(userEmail, a);

		//pwReset mail발송
		mailservice.pwresetMail(userEmail, a);
		return "redirect:/user/userList";
	}

	//가입승인
	@GetMapping("/permission/{userEmail}")
	public String permission(@PathVariable("userEmail") String userEmail) {

		//가입승인
		userService.permission(userEmail);

		//가입승인 mail발송
		mailservice.permissionMail(userEmail);

		return "redirect:/user/management";
	}

	//권한박탈
	@GetMapping("/authority/{permission}")
	public String authority (@PathVariable("permission") String permission) {

		userService.authority(permission);

		return "redirect:/user/userList";
	};

	//관리자추가
	@GetMapping("/admin")
	public String admin(Model model,
						UserCriteria cri,
						HttpServletRequest request,
						RedirectAttributes ra) {
		
		ArrayList<AdminVO> list = userService.admin(cri);
		model.addAttribute("list", list);
		

		if((int)request.getSession().getAttribute("role") == 1) {
			ra.addFlashAttribute("msg", "권한이 필요합니다.");
			return "redirect:"+request.getHeader("Referer");
		}

		
		//페이지네이션
		int total3 = userService.getTotal3(cri);
		UserPageVO pageVO3 = new UserPageVO(cri,total3);
		
		model.addAttribute("pageVO", pageVO3);
		
		return "user/admin";
	}
	
	//관리자회원가입
	@PostMapping("/admin")
	public String adminJoin(AdminVO vo) {
		
		//pw암호화
		String userPw = UserSha256.encrypt(vo.getUserPw());
		
		//System.out.println(userPw);
		//System.out.println(vo);
		
		vo.setUserPw(userPw);
		userService.adminJoin(vo);
		
		return "redirect:/user/admin";
	}
	

};


