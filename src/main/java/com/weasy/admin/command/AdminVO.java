package com.weasy.admin.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminVO { //관리자 VO
	
	private String userEmail;
	private String userPw;
	private String userName;
	private String phoneNum;
	private String memo;
	private int role;
	private int orderNum;

}
