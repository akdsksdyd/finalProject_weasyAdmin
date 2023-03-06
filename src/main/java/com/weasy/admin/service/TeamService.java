package com.weasy.admin.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.util.Criteria;

public interface TeamService {
	
	public ArrayList<TeamVO> getList(Model model,Criteria cri);
	public int getTotal(Criteria cri);

}