package com.weasy.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
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
							 RedirectAttributes ra,
							 @RequestPart("fileName") MultipartFile multipartFile) {
		
		// 공지사항 글 업로드
		int result = noticeService.noticeRegist(vo);
		
		// 공지사항 글 업로드 후 파일 정보 업로드
		int file_result = -1;
		if(!multipartFile.isEmpty()) {
			file_result = noticeService.noticeFileRegist(multipartFile);
		}
		
		if(result == 1 && (file_result == -1 || file_result == 1)) ra.addFlashAttribute("msg", "공지사항이 등록되었습니다.");
		else ra.addFlashAttribute("msg", "공지사항 등록에 실패했습니다.");
		
		return "redirect:/notice/noticeList";
	}
	
	@GetMapping("/noticeModify")
	public String noticeModify() {
		
		return "notice/noticeModify";
	}
	
	@GetMapping("/noticeModify/{noticeNo}")
	public String noticeModify(@PathVariable("noticeNo") int noticeNo,
							   RedirectAttributes ra) {

		ra.addFlashAttribute("vo", noticeService.getNoticeDetail(noticeNo));
		
		return "redirect:/notice/noticeModify";
	}
			
	@PostMapping("/deleteForm")
	public String noticeDelete(@RequestParam("noticeNo") int noticeNo,
							    RedirectAttributes ra) {
		
		int result = noticeService.noticeDelete(noticeNo);
		int file_result = noticeService.noticeFileDelete(noticeNo);
		
		if(result == 1 && file_result == 1) ra.addFlashAttribute("msg", "공지사항이 삭제되었습니다.");
		else ra.addFlashAttribute("msg", "공지사항 삭제에 실패하였습니다.");
		
		return "redirect:/notice/noticeList";
	}
	
	@PostMapping("/noticeUpdateForm")
	public String noticeUpdateForm(noticeListVO vo,
								   RedirectAttributes ra,
								   @RequestPart("fileName") MultipartFile multipartFile) {
		
		int result = noticeService.noticeUpdate(vo);
		int file_result = -1;
		if(!multipartFile.isEmpty()) {
			file_result = noticeService.noticeFileRegist(multipartFile, vo.getNoticeNo());
		}
		
		if(result == 1 && (file_result == -1 || file_result == 1)) ra.addFlashAttribute("msg", "공지사항이 수정되었습니다.");
		else ra.addFlashAttribute("msg", "공지사항 수정에 실패했습니다.");
		
		return "redirect:/notice/noticeList";
	}
	
}
