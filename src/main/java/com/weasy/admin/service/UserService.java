package com.weasy.admin.service;

import java.util.ArrayList;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

public interface UserService {
	
	//management
	public ArrayList<UserVO> getList(String userId, Criteria cri);
	
	//userList
	public ArrayList<UserVO> memberList(String userId, Criteria cri);
	
	//PW Reset
	public void pwReset(UserVO vo);
	
	//testCode
//	public int userRegist(UserVO vo);
	
	
	public int getTotal(String userId, Criteria cri); 

}
