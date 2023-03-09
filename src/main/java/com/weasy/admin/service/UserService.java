package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.List;

import com.weasy.admin.command.UserLogVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

public interface UserService {
	
	//management
	public ArrayList<UserVO> getList(String userId, Criteria cri);
	
	//userlist
	public ArrayList<UserVO> memberList(String userId, Criteria cri);
//	spublic ArrayList<UserLogVO> userlogList(String userId, Criteria cri);
	
	
//	public List<UserLogVO> loginlogList(UserLogVO vo);
	
	public int getTotal(String userId, Criteria cri); 

}
