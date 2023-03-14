package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public ArrayList<UserVO>managementList(Criteria cri) {
		return userMapper.managementList(cri);
	}
	
	@Override
	public ArrayList<UserVO> userList(Criteria cri) {
		return userMapper.userList(cri);
	}
	
	@Override
	public int pwReset(String userEmail, String birth) {
		return userMapper.pwReset(userEmail, birth);
	}

	@Override
	public int permission(String userEmail) {
		return userMapper.permission(userEmail);
	}



	
	/*
	@Override
	public int permission(UserVO permission) {
		return userMapper.permission(permission);
	}
	*/


	

}
