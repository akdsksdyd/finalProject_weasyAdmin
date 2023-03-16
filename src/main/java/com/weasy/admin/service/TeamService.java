package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.ui.Model;

import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

public interface TeamService {
	
	public ArrayList<TeamVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	public ArrayList<UserVO> getTeamList(String teamName);
	public int deleteTeam(String userEmail);
	public ArrayList<UserVO> searchId(String searchId,int teamNo);
	public Integer insertTeam(String userEmail, int teamNo ,int role);
	public int updateRole(int role,String userEmail,int teamNo);
	public ArrayList<TaskCurrentCardVO> teamCurrentList(String TeamName);
	public int statusChange(int teamNo,String teamStatus);
	

}
