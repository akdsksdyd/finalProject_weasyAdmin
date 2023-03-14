package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.util.NoticeCriteria;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public ArrayList<noticeListVO> getNoticeList(NoticeCriteria cri) {
		
		return noticeMapper.getNoticeList(cri);
	}

	@Override
	public int getNoticeTotal() {
		
		return noticeMapper.getNoticeTotal();
	}

	@Override
	public int noticeRegist(noticeListVO vo) {
		
		return noticeMapper.noticeRegist(vo);
	}
	
	
}
