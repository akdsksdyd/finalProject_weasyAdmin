
package com.weasy.admin.controller;

import java.util.ArrayList;

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
	//팀원삭제
	@PostMapping("/deleteTeam")
	public String deleteTeam(@RequestParam("userEmail") String userEmail,@RequestParam("teamNo") int teamNo) {

		int result = teamService.deleteTeam(userEmail,teamNo);

		if(result != 0) {
			return "삭제성공";
		}else {
			return "삭제실패";
		}

	}

	//팀원목록을 다시 그려주는기능
	@PostMapping("/teamListUpdate")
	public ArrayList<UserVO>teamListUpdate(@RequestParam("teamNo") String teamNo){

		ArrayList<UserVO> list = teamService.getTeamList(teamNo);

		return list;
	}
	
	//아이디 및 닉네임검색기능
	@PostMapping("/searchId")
	public ArrayList<UserVO> searchId(@RequestParam("searchId") String searchId,@RequestParam("teamNo") int teamNo){
		ArrayList<UserVO> list = teamService.searchId(searchId, teamNo);
		return list;
	}
	//팀원추가기능
	@PostMapping("/insertTeam")
	public ArrayList<UserVO> insertTeam(@RequestParam("userEmail")String userEmail,@RequestParam("teamNo") int teamNo, @RequestParam("role") int role,@RequestParam("searchId") String searchId) {
		
		Integer result = teamService.insertTeam(userEmail, teamNo,role);
		ArrayList<UserVO> list = teamService.searchId(searchId, teamNo);
		
		
		if(result == null) {
			return list;
		}else {
			return null;
		}
		
	}
	//팀원의 권한을 변경
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
