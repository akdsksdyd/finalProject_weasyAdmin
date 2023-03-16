package com.weasy.admin.command;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class noticeListVO { //공지사항 리스트 VO
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Timestamp noticeRegdate;
	private String noticeLevel;
	private String userEmail;
	
	// 하나의 공지에 여러 사진일 수 있으니 리스트로 처리
	private ArrayList<String> fileList;

}
//noticeNo   INT primary key auto_increment,
//noticeTitle   VARCHAR(30) NULL,
//noticeContent   VARCHAR(200) NULL,
//noticeRegdate   TIMESTAMP DEFAULT NOW(),
//noticeLevel   VARCHAR(30) NULL,
//userEmail   VARCHAR(30) NULL