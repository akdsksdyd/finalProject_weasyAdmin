package com.weasy.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weasy.admin.service.BoardService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	
	@GetMapping("/noticeList")
	public String noticeList() {
		
		
		
		return "notice/noticeList";
	}
	
}
