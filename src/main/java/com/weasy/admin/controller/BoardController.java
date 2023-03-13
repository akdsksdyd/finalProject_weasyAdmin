package com.weasy.admin.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weasy.admin.command.AuthorityVO;
import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.service.BoardService;
import com.weasy.admin.util.BoardCriteria;
import com.weasy.admin.util.BoardPageVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	BoardService boardService; 
	
	// 대시보드 요약 화면
	@GetMapping("/boardSummary")
	public String boardSummary(Model model) {
		
		Map<String, Object> dataMap = boardService.getDashboardSummaryChart();
		model.addAttribute("dataMap", dataMap);
		
		return "board/boardSummary";
	}
	
	// 팀별 태스크 현황 화면
	@GetMapping("/taskCurrent")
	public String taskCurrent(Model model) {
		
		ArrayList<TaskCurrentCardVO> list = boardService.getTaskCurrentList();
		model.addAttribute("list", list);
		
		return "board/taskCurrent";
	}
	
	// 팀별 태스크 진척률 화면
	@GetMapping("/taskProgress")
	public String taskProgress(Model model,
							   BoardCriteria cri) {
		
		ArrayList<TaskProgressVO> list = boardService.getTaskProgressList(cri); 
		model.addAttribute("list", list);
		
		int total = boardService.getTeamTotal(cri);
		BoardPageVO pageVO = new BoardPageVO(cri, total);
		model.addAttribute("pageVO", pageVO);
		
		return "board/taskProgress";
	}
	
}
