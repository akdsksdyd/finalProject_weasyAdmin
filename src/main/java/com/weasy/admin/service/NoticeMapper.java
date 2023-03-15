package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.util.NoticeCriteria;

@Mapper
public interface NoticeMapper {
	
	// 공지사항 화면 리스트
	public ArrayList<noticeListVO> getNoticeList(NoticeCriteria cri);
	public int getNoticeTotal();

	// 공지사항 글 등록
	public int noticeRegist(noticeListVO vo);
	// 공지사항 파일 등록	
	public int noticeFileRegist(String filePath);
	
}
