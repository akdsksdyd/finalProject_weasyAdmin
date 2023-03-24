package com.weasy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weasy.admin.command.TaskCurrentCardVO;
import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import com.weasy.admin.service.BoardService;
import com.weasy.admin.service.TeamService;
import com.weasy.admin.util.Criteria;
import com.weasy.admin.util.PageVO;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired private TeamService teamService;
    @GetMapping("/teamList")
    public String teamList(Model model, Criteria cri) {
        ArrayList < TeamVO > list = teamService.getList(cri);
        model.addAttribute("list", list);
        int total = teamService.getTotal(cri);
        System.out.println("토탈" + total);
        PageVO pageVO = new PageVO(cri, total);
        System.out.println(pageVO.toString());
        model.addAttribute("pageVO", pageVO);
        return "team/teamList";
    }
    @GetMapping("/teamDetail")
    public String teamDetail(@RequestParam("teamNo")String teamNo, Model model) {
        ArrayList < TaskCurrentCardVO > lists = teamService.teamCurrentList(teamNo);
        ArrayList < UserVO > list = teamService.getTeamList(teamNo);
        System.out.println(list.toString());
        model.addAttribute("lists", lists);
        model.addAttribute("list", list);
        return "team/teamDetail";
    }
    @GetMapping("/statusChange")
    public String statusChange(@RequestParam("teamStatus")String teamStatus, @RequestParam("teamNo")int teamNo) {
        int result = teamService.statusChange(teamStatus, teamNo);
        return "redirect:/team/teamList";
    }
    
    @GetMapping("index")
    public String indexs() {
    	
    	return "team/index";
    }
}