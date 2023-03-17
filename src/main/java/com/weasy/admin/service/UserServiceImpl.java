package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weasy.admin.command.AdminVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	//management
	@Override
	public ArrayList<UserVO>managementList(Criteria cri) {
		return userMapper.managementList(cri);
	}
	
	//userList
	@Override
	public ArrayList<UserVO> userList(Criteria cri) {
		return userMapper.userList(cri);
	}
	
	//PW Reset
	@Override
	public int pwReset(String userEmail, String birth) {
		return userMapper.pwReset(userEmail, birth);
	}

	//가입 승인
	@Override
	public int permission(String userEmail) {
		return userMapper.permission(userEmail);
	}

	//권한 박탈
	@Override
	public int authority(String permission) {
		return userMapper.authority(permission);
	}

	//관리자추가
	@Override
	public ArrayList<AdminVO> admin(Criteria cri) {
		return userMapper.admin(cri);
	}

}
