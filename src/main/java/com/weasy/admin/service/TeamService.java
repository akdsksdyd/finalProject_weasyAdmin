package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.Criteria;

public interface TeamService {
	
	public ArrayList<TeamVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	public ArrayList<UserVO> getTeamList(String teamName);

}
