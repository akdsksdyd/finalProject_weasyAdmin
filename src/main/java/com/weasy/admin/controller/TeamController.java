package com.weasy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.service.TeamService;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.PageVO;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/teamList")
	public String teamList(Model model,Criteria cri) {

		ArrayList<TeamVO>list = teamService.getList(cri);
		
		
		model.addAttribute("list",list);
		
		System.out.println("카테" + cri.getCategory());
		System.out.println("검색명" + cri.getKeyword());
		
		int total = teamService.getTotal(cri);
		
		System.out.println("토탈" + total);
		
		PageVO pageVO = new PageVO(cri, total);
		
		System.out.println(pageVO.toString());
		model.addAttribute("pageVO", pageVO);
		
		return "team/teamList";
	}
	
	@GetMapping("/teamDetail")
	public String teamDetail(@RequestParam("teamName")String teamName,Model model) {
		System.out.println("팀이름값" + teamName);
		
		ArrayList<UserVO>list = teamService.getTeamList(teamName);
		
		model.addAttribute("list",list);
		
		return "team/teamDetail";
	}

}
