package com.weasy.admin.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class noticeVO { //알림VO

	private int noticeNo;
	private String userEmail;
	private String message;
	
}
//noticeNo   INT(8) primary key auto_increment,
//userEmail   VARCHAR(30) NOT NULL,
//message   VARCHAR(200) NOT NULL