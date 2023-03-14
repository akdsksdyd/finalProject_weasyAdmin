
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
	
	
	@PostMapping("/searchId")
	public ArrayList<UserVO> searchId(@RequestParam("searchId") String searchId,@RequestParam("teamNo") int teamNo){
		ArrayList<UserVO> list = teamService.searchId(searchId, teamNo);
		return list;
	}
	@PostMapping("/insertTeam")
	public ArrayList<UserVO> insertTeam(@RequestParam("userEmail")String userEmail,@RequestParam("teamNo") int teamNo, @RequestParam("role") int role,@RequestParam("searchId") String searchId) {
		
		Integer result = teamService.insertTeam(userEmail, teamNo,role);
		System.out.println("성공여부" + result);
		ArrayList<UserVO> list = teamService.searchId(searchId, teamNo);
		
		
		if(result == null) {
			return list;
		}else {
			return null;
		}
		
	}
	
	@PostMapping("/updateRole")
	public String updateRole(@RequestParam("role")int role,@RequestParam("userEmail")String userEmail,@RequestParam("teamNo")int teamNo) {
		
		int result = teamService.updateRole(role,userEmail,teamNo);
		
		if(result == 1) {
			return "권한변경";
		}else {
			return "권한변경실패";
		}
		
	}


}
