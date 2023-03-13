package com.weasy.admin.service;

import java.util.ArrayList;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

public interface UserService {
	
	//management
	public ArrayList<UserVO> managementList(Criteria cri);
	
	//userList
	public ArrayList<UserVO> userList(Criteria cri);
	
	//permission
	 public int permission(UserVO permission);
	

}
