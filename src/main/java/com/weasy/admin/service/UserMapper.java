package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weasy.admin.command.AdminVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.UserCriteria;

@Mapper
public interface UserMapper {
	
	//management
	public ArrayList<UserVO>managementList(@Param("cri") UserCriteria cri);
	public int getTotal(@Param("cri") UserCriteria cri);
	
	//userList
	public ArrayList<UserVO>userList(@Param("cri") UserCriteria cri);
	public int getTotal2(@Param("cri") UserCriteria cri);
	
	//pwReset
	public int pwReset(@Param("userEmail") String userEmail,
					   @Param("birth") String birth);
		
	//가입승인
	public int permission(String userEmail);
	
	//권한박탈
	public int authority(String permission);
	
	//관리자추가
	public ArrayList<AdminVO> admin(@Param("cri") UserCriteria cri);
	public int getTotal3(@Param("cri") UserCriteria cri);
	
	//관리자회원가입
	public int adminJoin(AdminVO vo);
	
	//이메일중복검사
	public int idCheck(String id);

}
