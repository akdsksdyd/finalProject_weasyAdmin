package com.weasy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weasy.admin.service.BoardService;


@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("boardService")
	BoardService boardService;

	@PostMapping("/login")
	public String loginCheck(@RequestParam("id") String id,
							 @RequestParam("pw") String pw,
							 HttpServletRequest request,
							 RedirectAttributes ra) {
		
		int check = boardService.loginCheck(id, pw);
		
		if(check != 0) {
			request.getSession().setAttribute("user_id", id);
			return "redirect:/board/boardSummary";
		}else {
			ra.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
			return "redirect:/";
		}
		
	}
	
}
