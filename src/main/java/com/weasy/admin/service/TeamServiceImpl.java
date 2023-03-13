package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	public ArrayList<UserVO> getTeamList(String teamName) {
		return teamMapper.getTeamList(teamName);
	}

	@Override
	public int deleteTeam(String userEmail) {
		
		return teamMapper.deleteTeam(userEmail);
	}

	@Override
	public ArrayList<UserVO> searchId(String searchId, int teamNo) {
		return teamMapper.searchId(searchId, teamNo);
	}

	
	
	

	
	
	
	
	

	

	
	
	

}
