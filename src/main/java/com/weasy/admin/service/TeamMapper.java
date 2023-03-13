package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface TeamMapper {
	
	public ArrayList<TeamVO> getList(@Param("cri")Criteria cri);
	public int getTotal(@Param("cri")Criteria cri);
	public ArrayList<UserVO> getTeamList(String teamName);
	public int deleteTeam(String userEmail);
	public ArrayList<UserVO> searchId(@Param("searchId")String searchId,@Param("teamNo")int teamNo);
}
