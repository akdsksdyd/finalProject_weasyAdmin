package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weasy.admin.command.AuthorityVO;
import com.weasy.admin.command.CompleteTaskChartVO;
import com.weasy.admin.command.ProgressingTaskChartVO;
import com.weasy.admin.command.TaskCountChartVO;
import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;
import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.util.BoardCriteria;

@Mapper
public interface BoardMapper {
	
	// 샘플데이터 삽입용 
	public void taskInsert(TaskVO vo);
	public void taskDetailInsert(TaskDetailVO vo);
	public void updateStatus(TaskVO vo);
	public void setAuthority(AuthorityVO vo);
	
	/**
	 * taskProgress 화면 리스트용
	 * @param cri 페이징용
	 * @return ArrayList<TaskProgressVO>
	 */
	public ArrayList<TaskProgressVO> getTaskProgressList(BoardCriteria cri);
	
	// taskProressDetail 화면 데이터
	public ArrayList<TaskVO> getTaskProgressDetail(String teamName);
	public ArrayList<TaskVO> getTaskProgressRate(String teamName);
	
	// taskCurrent 화면 리스트 데이터
	public ArrayList<TaskCurrentCardVO> getTaskCurrentList();
	
	// DashBoard Summary 화면 차트, 공지용 데이터
	public int getTeamTotal();
	public int getTeamTotal(BoardCriteria cri);
	public ArrayList<TaskCountChartVO> getTaskCountChart();
	public ArrayList<CompleteTaskChartVO> getCompleteTaskChart();
	public ArrayList<ProgressingTaskChartVO> getProgressingTaskChart();
	public int[] getTotalTaskProgress();
	public ArrayList<noticeListVO> getBoardNoticeList();
	
	// 로그인 인터셉트용
	public int loginCheck(@Param("id") String id, @Param("pw") String pw);
	
}
