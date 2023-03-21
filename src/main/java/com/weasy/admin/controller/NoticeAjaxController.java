package com.weasy.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weasy.admin.command.NoticeListUploadVO;
import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.service.NoticeService;

@RestController
public class NoticeAjaxController {
	
	@Autowired
	NoticeService noticeService;
	
	// 공지사항 상세 화면 모달에 그릴 데이터
	@GetMapping("/noticeDetail/{noticeNo}")
	public noticeListVO getNoticeDetail(@PathVariable("noticeNo") int noticeNo) {
		
		return noticeService.getNoticeDetail(noticeNo);
	}
	
	// 공지사항 수정 화면에서 파일 삭제 요청
	@PostMapping("/notice_file_delete")
	public String noticeFileDelete(@RequestBody NoticeListUploadVO vo) {
		
		// 파일 테이블에서 삭제
		noticeService.noticeFileDelete2(vo.getFilePath());
		
		// s3에서 삭제
		noticeService.noticeS3FileDelete(vo.getFilePath().split("amazonaws.com/")[1]);
		
		return "파일이 삭제되었습니다.";
	}
	
}
