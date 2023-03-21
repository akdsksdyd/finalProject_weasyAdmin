package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

@Service("TeamService")
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamMapper teamMapper;

	@Override
	public ArrayList<TeamVO> getList(Criteria cri) {
		return teamMapper.getList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return teamMapper.getTotal(cri);
	}

	@Override
	public ArrayList<UserVO> getTeamList(String teamNo) {
		return teamMapper.getTeamList(teamNo);
	}

	@Override
	public int deleteTeam(String userEmail,int teamNo) {
		
		return teamMapper.deleteTeam(userEmail,teamNo);
	}

	@Override
	public ArrayList<UserVO> searchId(String searchId, int teamNo) {
		return teamMapper.searchId(searchId, teamNo);
	}

	@Override
	public Integer insertTeam(String userEmail, int teamNo, int role) {
		return teamMapper.insertTeam(userEmail, teamNo, role);
	}

	@Override
	public int updateRole(int role,String userEmail,int teamNo) {
		return teamMapper.updateRole(role,userEmail,teamNo);
	}

	@Override
	public ArrayList<TaskCurrentCardVO> teamCurrentList(String TeamName) {
		return teamMapper.teamCurrentList(TeamName);
	}

	@Override
	public int statusChange(String teamStatus, int teamNo) {
		return teamMapper.statusChange(teamStatus, teamNo);
	}

	
	
	
	
		

	

	
	
	

	
	
	
	
	

	

	
	
	

}
