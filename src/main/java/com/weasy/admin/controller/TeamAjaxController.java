package com.weasy.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.service.TeamService;

@RestController
public class TeamAjaxController {
	
	@Autowired
	TeamService teamService;
	

}
