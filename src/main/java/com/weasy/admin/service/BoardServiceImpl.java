package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskProgressVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public ArrayList<TaskProgressVO> getTaskProgressList() {
		
		return boardMapper.getTaskProgressList();
	}

	@Override
	public Map<String, ArrayList<TaskDetailVO>> getTaskProgressDetail(String teamName) {
		
		
		Map<String, ArrayList<TaskDetailVO>> map = new HashMap<>();
		
		
		
		return map;
	}
	
}

