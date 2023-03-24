package com.weasy.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weasy.admin.command.AuthorityVO;
import com.weasy.admin.command.CompleteTaskChartVO;
import com.weasy.admin.command.ProgressingTaskChartVO;
import com.weasy.admin.command.TaskCountChartVO;
import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.command.TaskVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.util.BoardCriteria;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public ArrayList<TaskProgressVO> getTaskProgressList(BoardCriteria cri) {
		
		return boardMapper.getTaskProgressList(cri);
	}

	@Override
	public Map<String, ArrayList<TaskVO>> getTaskProgressDetail(String teamName) {
		
		Map<String, ArrayList<TaskVO>> map = new HashMap<>();
		
		map.put("rateList", boardMapper.getTaskProgressRate(teamName));
		map.put("statusList", boardMapper.getTaskProgressDetail(teamName));
		
		return map;
	}

	@Override
	public ArrayList<TaskCurrentCardVO> getTaskCurrentList() {
		
		return boardMapper.getTaskCurrentList();
	}

	@Override
	public Map<String, Object> getDashboardSummaryChart() {
		
		Map<String, Object> map = new HashMap<>();
		
		// 차트용
		ArrayList<TaskCountChartVO> taskCountChart = boardMapper.getTaskCountChart();
		ArrayList<CompleteTaskChartVO> completeTaskChart = boardMapper.getCompleteTaskChart();
		ArrayList<ProgressingTaskChartVO> progressingTaskChart = boardMapper.getProgressingTaskChart();
		int[] totalTaskProgress = boardMapper.getTotalTaskProgress();
		
		// 단일 데이터
		int teamTotal = boardMapper.getTeamTotal();
		
		// 중요 공지 등 5개
		ArrayList<noticeListVO> noticeList = boardMapper.getBoardNoticeList();
		
		map.put("taskCountChart", taskCountChart);
		map.put("completeTaskChart", completeTaskChart);
		map.put("progressingTaskChart", progressingTaskChart);
		map.put("teamTotal", teamTotal);
		map.put("totalTaskProgress", totalTaskProgress);
		map.put("noticeList", noticeList);
		
		return map;
	}

	@Override
	public int getTeamTotal(BoardCriteria cri) {
		
		return boardMapper.getTeamTotal(cri);
	}

	@Override
	public UserVO loginCheck(String id, String pw) {
		
		return boardMapper.loginCheck(id, pw);
	}
	
}

