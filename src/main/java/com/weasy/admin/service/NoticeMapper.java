package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	public int noticeFileRegist(@Param("filePath") String filePath, 
			@Param("noticeNo") int noticeNo);
	// 파일 등록 시 새로 등록될 noticeNo(PK)값 가져오기
	public int getNoticeNoMax();

	// 공지사항 디테일 화면
	public noticeListVO getNoticeDetail(int noticeNo);

	// 공지사항 수정
	public int noticeUpdate(noticeListVO vo);

	// 공지사항 글 삭제
	public int noticeDelete(int noticeNo);
	// 공지사항 파일 정보 삭제
	public int noticeFileDelete(int noticeNo);
	public int noticeFileDelete2(String filePath);
	// s3 파일 삭제를 위한 filePath 가져오기
	public String[] getFilePath(int noticeNo);

}
