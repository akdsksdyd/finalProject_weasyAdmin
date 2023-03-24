package com.weasy.admin.service;

import java.util.ArrayList;

import com.weasy.admin.command.AdminVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.UserCriteria;

public interface UserService {
	
	//management
	public ArrayList<UserVO> managementList(UserCriteria cri);
	public int getTotal(UserCriteria cri);
	
	//userList
	public ArrayList<UserVO> userList(UserCriteria cri);
	public int getTotal2(UserCriteria cri);
	
	//pwReset
	public int pwReset(String userEmail, String birth);
	
	//가입승인
	public int permission(String userEmail);

	//권한박탈
	public int authority(String permission);
	
	//관리자추가
	public ArrayList<AdminVO> admin(UserCriteria cri);
	public int getTotal3(UserCriteria cri);
	
	//관리자회원가입
	public int adminJoin(AdminVO vo);

	//이메일중복검사
	public int idCheck(String id);

	
}
