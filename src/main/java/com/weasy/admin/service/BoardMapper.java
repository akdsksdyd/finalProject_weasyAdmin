package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.weasy.admin.command.AuthorityVO;
import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;

@Mapper
public interface BoardMapper {

	// 샘플데이터 삽입용 
	public void taskInsert(TaskVO vo);
	public void taskDetailInsert(TaskDetailVO vo);
	public void updateStatus(TaskVO vo);
	public void setAuthority(AuthorityVO vo);
	
	// taskProgress 리스트 데이터
	public ArrayList<TaskProgressVO> getTaskProgressList();
	
	// taskProressDetail 화면 데이터
	public ArrayList<TaskVO> getTaskProgressDetail(String teamName);
	public ArrayList<TaskVO> getTaskProgressRate(String teamName);
	
	// taskCurrent 화면 리스트 데이터
	public ArrayList<TaskCurrentCardVO> getTaskCurrentList();
	
}
