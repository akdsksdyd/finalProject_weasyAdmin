package com.weasy.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.service.BoardService;

@RestController
public class BoardAjaxController {

	@Autowired
	BoardService boardService; 
	
	@GetMapping("/taskProgressDetail/{teamName}")
	public Map<String, ArrayList<TaskDetailVO>> taskProgressDetail(@PathVariable("teamName") String teamName) {
		
		Map<String, ArrayList<TaskDetailVO>> map = boardService.getTaskProgressDetail(teamName);
		
		for(String key : map.keySet()) {
			
			ArrayList<TaskDetailVO> list = map.get(key);
			System.out.println(list.toString());
		}
		
		return map;
	}
	
}
