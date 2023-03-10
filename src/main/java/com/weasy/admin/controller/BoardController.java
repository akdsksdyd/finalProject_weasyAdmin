package com.weasy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weasy.admin.command.AuthorityVO;
import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TaskProgressVO;
import com.weasy.admin.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService; 
	
	@GetMapping("/boardSummary")
	public String boardSummary() {
		
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
	public String taskProgress(Model model) {
		
		ArrayList<TaskProgressVO> list = boardService.getTaskProgressList(); 
		model.addAttribute("list", list);
		
		return "board/taskProgress";
	}
	
}
