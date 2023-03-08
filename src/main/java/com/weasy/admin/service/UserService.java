package com.weasy.admin.service;

import java.util.ArrayList;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

public interface UserService {
	
	//조회: 특정회원정보만 조회
	public ArrayList<UserVO> getList(String userId, Criteria cri);

	public int getTotal(String userId, Criteria cri); 

}
