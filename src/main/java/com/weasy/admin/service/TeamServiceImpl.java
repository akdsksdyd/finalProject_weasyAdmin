package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.weasy.admin.command.TeamVO;
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
		// TODO Auto-generated method stub
		return teamMapper.getTotal(cri);
	}

	

	
	
	

}
