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
	public ArrayList<UserVO>getList(String userId, Criteria cri) {
		return userMapper.getList(userId, cri);
	}

	@Override
	public int getTotal(String userId, Criteria cri) {
		return userMapper.getTotal(userId,cri);
	}

}
