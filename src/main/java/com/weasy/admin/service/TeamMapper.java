package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface TeamMapper {
	
	public ArrayList<TeamVO> getList(@Param("cri")Criteria cri);
	public int getTotal(@Param("cri")Criteria cri);
	public ArrayList<UserVO> getTeamList(String teamNo);
	public int deleteTeam(@Param("userEmail") String userEmail,@Param("teamNo")int teamNo);
	public ArrayList<UserVO> searchId(@Param("searchId")String searchId,@Param("teamNo")int teamNo);
	public Integer insertTeam(@Param("userEmail") String userEmail,@Param("teamNo") int teamNo ,@Param("role")int role);
    public int updateRole(@Param("role") int role,@Param("userEmail")String userEmail,@Param("teamNo") int teamNo);
    public ArrayList<TaskCurrentCardVO> teamCurrentList(String TeamName);
    public int statusChange(@Param("teamStatus")String teamStatus,@Param("teamNo")int teamNo);
}
