package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;

@Mapper
public interface BoardMapper {

	public void taskInsert(TaskVO vo);
	public void taskDetailInsert(TaskDetailVO vo);
	
	// status 테스트용 업데이트
	public void updateStatus(TaskVO vo);
	
	// taskProress 테이블 데이터
	public ArrayList<TaskProgressVO> getTaskProgressList();
	// taskProressDetail 화면 데이터
	public ArrayList<TaskDetailVO> getTaskProgressDetail_ing(String teamName);
	public ArrayList<TaskDetailVO> getTaskProgressDetail_end(String teamName);
	
	public TaskVO getTaskProgressRate(String teamName);
}
