package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.weasy.admin.command.TaskCountChartVO;
import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;
import com.weasy.admin.util.BoardCriteria;

public interface BoardService {
	
	// taskProgress 화면 게시판 리스트용
	public ArrayList<TaskProgressVO> getTaskProgressList(BoardCriteria cri);
	
	// taskProgress 상세화면 데이터용
	/**
	 * 역할 정보
	 * @param teamName ㅇㅇ
	 * @return ㅇㅇㅇㅇㅇ
	 */
	public Map<String, ArrayList<TaskVO>> getTaskProgressDetail(String teamName);
	
	// taskCurrent 화면 카드에 뿌릴 데이터
	public ArrayList<TaskCurrentCardVO> getTaskCurrentList();
	
	// boardSummary 화면 차트 데이터용
	public Map<String, Object> getDashboardSummaryChart();
	
	// 활동중인 팀 전체 수
	public int getTeamTotal(BoardCriteria cri);
	
	// 로그인 인터셉트용
	public int loginCheck(String id, String pw);
	
}
