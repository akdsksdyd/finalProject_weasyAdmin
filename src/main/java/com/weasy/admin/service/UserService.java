package com.weasy.admin.service;

import java.util.ArrayList;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

public interface UserService {
	
	//management
	public ArrayList<UserVO> managementList(Criteria cri);
	
	//userList
	public ArrayList<UserVO> userList(Criteria cri);
	
	//PW Reset
	public int pwReset(String userEmail, String birth);
	
	//가입 승인
	public int permission(String userEmail);

	//권한 박탈
	public int authority(String permission);
	
	
	

}
