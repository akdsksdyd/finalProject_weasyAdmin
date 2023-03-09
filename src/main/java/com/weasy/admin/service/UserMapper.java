package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weasy.admin.command.UserLogVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface UserMapper {
	
	public ArrayList<UserVO>getList(@Param("userId") String userId, 
									@Param("cri") Criteria cri);
	
	public ArrayList<UserVO>memberList(@Param("userId") String userId, 
									   @Param("cri") Criteria cri);
	
//	public ArrayList<UserLogVO>userlogList(@Param("userId") String userId, 
//											@Param("cri") Criteria cri);
//	
//	public List<UserLogVO> loginlogList(UserLogVO vo);

	public int getTotal(@Param("userId")String userId, 
						@Param("cri")Criteria cri); 

}
