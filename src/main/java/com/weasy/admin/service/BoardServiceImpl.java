package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public ArrayList<TaskProgressVO> getTaskProgressList() {
		
		return boardMapper.getTaskProgressList();
	}

	@Override
	public Map<String, ArrayList<TaskVO>> getTaskProgressDetail(String teamName) {
		
		Map<String, ArrayList<TaskVO>> map = new HashMap<>();
		
		map.put("rateList", boardMapper.getTaskProgressRate(teamName));
		map.put("statusList", boardMapper.getTaskProgressDetail(teamName));
		
		return map;
	}
	
}

