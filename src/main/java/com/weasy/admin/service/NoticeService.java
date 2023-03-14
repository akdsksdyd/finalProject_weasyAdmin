package com.weasy.admin.service;

import java.util.ArrayList;

import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.util.NoticeCriteria;

public interface NoticeService {
	
	// 공지사항 화면 리스트
	public ArrayList<noticeListVO> getNoticeList(NoticeCriteria cri);
	public int getNoticeTotal();
	
	// 공지사항 등록
	public int noticeRegist(noticeListVO vo);
	
}
