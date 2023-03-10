package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface UserMapper {
	
	//management
	public ArrayList<UserVO>getList(@Param("userId") String userId, 
									@Param("cri") Criteria cri);
	
	//userList
	public ArrayList<UserVO>memberList(@Param("userId") String userId, 
									   @Param("cri") Criteria cri);
	
	//PW Reset
	public void pwReset(UserVO vo); 

	//testCode
//	public int userRegist(UserVO vo);
	
	
	
	public int getTotal(@Param("userId")String userId, 
						@Param("cri")Criteria cri);



}
