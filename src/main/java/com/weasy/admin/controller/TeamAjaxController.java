
package com.weasy.admin.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired; import
org.springframework.ui.Model; import
org.springframework.web.bind.annotation.GetMapping; import
org.springframework.web.bind.annotation.PostMapping; import
org.springframework.web.bind.annotation.RequestParam; import
org.springframework.web.bind.annotation.RestController;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.command.UserVO;
import
com.weasy.admin.service.TeamService;

@RestController public class TeamAjaxController {

	@Autowired TeamService teamService;

	@PostMapping("/deleteTeam")
	public String deleteTeam(@RequestParam("userEmail") String userEmail) {

		int result = teamService.deleteTeam(userEmail);

		if(result != 0) {
			return "삭제성공";
		}else {
			return "삭제실패";
		}

	}


	@PostMapping("/teamListUpdate")
	public ArrayList<UserVO>teamListUpdate(@RequestParam("teamNo") String teamNo){

		ArrayList<UserVO> list = teamService.getTeamList(teamNo);

		return list;
	}


}
