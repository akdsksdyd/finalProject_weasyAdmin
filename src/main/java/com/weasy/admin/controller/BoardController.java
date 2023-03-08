package com.weasy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/taskCurrent")
	public String taskCurrent() {
		
		return "board/taskCurrent";
	}
	
	@GetMapping("/taskProgress")
	public String taskProgress(Model model) {
		
		ArrayList<TaskProgressVO> list = boardService.getTaskProgressList(); 
		model.addAttribute("list", list);
		
		return "board/taskProgress";
	}
	
}
