package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface UserMapper {
	
	//management
	public ArrayList<UserVO>managementList(@Param("cri") Criteria cri);
 	
	//userList
	public ArrayList<UserVO>userList(@Param("cri") Criteria cri);
	
	//permission
	 public int permission(UserVO permission);
	
	
	



}
