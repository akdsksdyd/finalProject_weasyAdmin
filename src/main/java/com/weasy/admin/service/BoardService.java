package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.weasy.admin.command.TaskCountChartVO;
import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.util.BoardCriteria;

public interface BoardService {
	
	/**
	 * taskProgress 화면 리스트용
	 * @param cri 페이징용
	 * @return ArrayList<TaskProgressVO>
	 */
	public ArrayList<TaskProgressVO> getTaskProgressList(BoardCriteria cri);
	
	/**
	 * taskProgress 상세화면용
	 * @param teamName teamName 기준 조회
	 * @return Map<String, ArrayList<TaskVO>>
	 */
	public Map<String, ArrayList<TaskVO>> getTaskProgressDetail(String teamName);
	
	/**
	 * taskCurrent 화면 카드에 뿌릴 데이터
	 * @return ArrayList<TaskCurrentCardVO>
	 */
	public ArrayList<TaskCurrentCardVO> getTaskCurrentList();
	
	/**
	 * boardSummary 화면 차트 데이터용 
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getDashboardSummaryChart();
	
	/**
	 * 활동중인 전체 팀 수 가져오기
	 * @param cri 
	 * @return
	 */
	public int getTeamTotal(BoardCriteria cri);
	
	// 로그인 인터셉트용
	public UserVO loginCheck(String id, String pw);
	
}
