package com.weasy.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.service.NoticeService;
import com.weasy.admin.util.NoticeCriteria;
import com.weasy.admin.util.NoticePageVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	NoticeService noticeService;
	
	@GetMapping("/noticeList")
	public String noticeList(Model model,
							 NoticeCriteria cri) {
		
		model.addAttribute("list", noticeService.getNoticeList(cri));
		
		NoticePageVO pageVO = new NoticePageVO(cri, noticeService.getNoticeTotal());
		model.addAttribute("pageVO", pageVO);
		
		return "notice/noticeList";
	}
	
	@GetMapping("/noticeRegist")
	public String noticeRegist() {
		
		return "notice/noticeRegist";
	}
	
	@PostMapping("/noticeForm")
	public String noticeForm(noticeListVO vo,
							 RedirectAttributes ra) {
		
		int result = noticeService.noticeRegist(vo);
		
		if(result == 1) ra.addFlashAttribute("msg", "공지사항이 등록되었습니다.");
		else ra.addFlashAttribute("msg", "공지사항 등록에 실패했습니다.");
		
		return "redirect:/notice/noticeList";
	}
	
}
