package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskProgressVO;

public interface BoardService {
	
	public ArrayList<TaskProgressVO> getTaskProgressList();
	public Map<String, ArrayList<TaskDetailVO>> getTaskProgressDetail(String teamName);
	
}
