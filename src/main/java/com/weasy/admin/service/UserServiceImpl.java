package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weasy.admin.command.AdminVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.UserCriteria;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	//management
	@Override
	public ArrayList<UserVO>managementList(UserCriteria cri) {
		return userMapper.managementList(cri);
	}
	
	//management페이지네이션
	@Override
	public int getTotal(UserCriteria cri) {
		return userMapper.getTotal(cri);
	}
	
	//userList
	@Override
	public ArrayList<UserVO> userList(UserCriteria cri) {
		return userMapper.userList(cri);
	}
	
	//userList페이지네이션
	@Override
	public int getTotal2(UserCriteria cri) {
		return userMapper.getTotal2(cri);
	}
	
	//PW Reset
	@Override
	public int pwReset(String userEmail, String birth) {
		return userMapper.pwReset(userEmail, birth);
	}

	//가입승인
	@Override
	public int permission(String userEmail) {
		return userMapper.permission(userEmail);
	}

	//권한박탈
	@Override
	public int authority(String permission) {
		return userMapper.authority(permission);
	}

	//관리자추가
	@Override
	public ArrayList<AdminVO> admin(UserCriteria cri) {
		return userMapper.admin(cri);
	}
	
	//관리자추가 페이지네이션
	@Override
	public int getTotal3(UserCriteria cri) {
		return userMapper.getTotal3(cri);
	}

	//관리자회원가입
	@Override
	public int adminJoin(AdminVO vo) {
		System.out.println(vo);
		return userMapper.adminJoin(vo);
	}

	//이메일중복검사
	@Override
	public int idCheck(String id) {

		int cnt = userMapper.idCheck(id);
		System.out.println("cnt: " + cnt);
		
		return cnt;
	}

	

}
