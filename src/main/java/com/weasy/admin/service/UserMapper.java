package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface UserMapper {
	
	//조회: 특정회원정보만 조회
	public ArrayList<UserVO>getList(@Param("userId") String userId, 
									 @Param("cri") Criteria cri);

	public int getTotal(@Param("userId")String userId, 
						@Param("cri")Criteria cri); 

}
