package com.weasy.admin.service;

import org.apache.ibatis.annotations.Mapper;

import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskVO;

@Mapper
public interface BoardMapper {

	public void taskInsert(TaskVO vo);
	public void taskDetailInsert(TaskDetailVO vo);
	
	// status 테스트용 업데이트
	public void updateStatus(TaskVO vo);
	
}
