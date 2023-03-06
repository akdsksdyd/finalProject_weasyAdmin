package com.weasy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	@GetMapping("/boardSummary")
	public String boardSummary() {
		
		return "board/boardSummary";
	}
	
	@GetMapping("/taskCurrent")
	public String taskCurrent() {
		
		return "board/taskCurrent";
	}
	
	@GetMapping("/taskProgress")
	public String taskProgress() {
		
		return "board/taskProgress";
	}
	
}
