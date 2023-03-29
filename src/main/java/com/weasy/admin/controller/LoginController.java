package com.weasy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.service.BoardService;
import com.weasy.admin.service.UserSha256;


@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("boardService")
	BoardService boardService;
	
	// 로그인
	@PostMapping("/login")
	public String loginCheck(@RequestParam("id") String id,
							 @RequestParam("pw") String pw,
							 HttpServletRequest request,
							 RedirectAttributes ra) {
		
		String realPw = UserSha256.encrypt(pw);
		System.out.println(pw);
		System.out.println(realPw);
		UserVO vo = boardService.loginCheck(id, realPw);
		
		if(vo != null) {
			request.getSession().setAttribute("user_id", vo.getUserEmail());
			request.getSession().setAttribute("role", vo.getRole());
			return "redirect:/board/boardSummary";
		}else {
			ra.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
			return "redirect:/";
		}
		
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,
			 			 RedirectAttributes ra) {
		// 세션값 제거
		request.getSession().removeAttribute("user_id");
		request.getSession().removeAttribute("role");
		
		ra.addFlashAttribute("msg", "로그아웃되었습니다.");
		
		return "redirect:/";
	}
	
}
