package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.util.NoticeCriteria;

public interface NoticeService {
	
	// 공지사항 화면 리스트
	public ArrayList<noticeListVO> getNoticeList(NoticeCriteria cri);
	public int getNoticeTotal();
	
	// 공지사항 글 등록
	public int noticeRegist(noticeListVO vo);
	// 공지사항 파일(insert용) 등록
	public int noticeFileRegist(MultipartFile multipartFile);
	// 공지사항 파일(update용) 등록
	public int noticeFileRegist(MultipartFile multipartFile, int noticeNo);
	
	// 공지사항 디테일 화면
	public noticeListVO getNoticeDetail(int noticeNo);
	
	// 공지사항 수정
	public int noticeUpdate(noticeListVO vo);
	
	// 공지사항 글 삭제
	public int noticeDelete(int noticeNo);
	// 공지사항 파일 정보 삭제
	public int noticeFileDelete(int noticeNo);
	
}
