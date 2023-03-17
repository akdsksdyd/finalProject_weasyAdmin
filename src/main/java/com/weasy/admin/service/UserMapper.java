package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weasy.admin.command.AdminVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface UserMapper {
	
	//management
	public ArrayList<UserVO>managementList(@Param("cri") Criteria cri);
 	
	//userList
	public ArrayList<UserVO>userList(@Param("cri") Criteria cri);
	
	//pwReset
	public int pwReset(@Param("userEmail") String userEmail,
					   @Param("birth") String birth);
		
	//가입승인
	public int permission(String userEmail);
	
	//권한박탈
	public int authority(String permission);
	
	//관리자추가
	public ArrayList<AdminVO> admin(@Param("cri") Criteria cri);

}
