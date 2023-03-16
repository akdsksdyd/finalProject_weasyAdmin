package com.weasy.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.service.NoticeService;

@RestController
public class NoticeAjaxController {
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/noticeDetail/{noticeNo}")
	public noticeListVO getNoticeDetail(@PathVariable("noticeNo") int noticeNo) {
		
		return noticeService.getNoticeDetail(noticeNo);
	}
	
}
