package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;

public interface BoardService {
	
	public ArrayList<TaskProgressVO> getTaskProgressList();
	public Map<String, ArrayList<TaskVO>> getTaskProgressDetail(String teamName);
	public ArrayList<TaskCurrentCardVO> getTaskCurrentList();
	
}
