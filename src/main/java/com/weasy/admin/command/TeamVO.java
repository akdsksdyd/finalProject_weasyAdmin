package com.weasy.admin.command;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamVO { //팀 VO
	
	private int teamNo;
	private LocalDateTime teamRegdate;
	private LocalDateTime endDate;
	private String teamName;
	private String teamGoal;
	private String userEmail;
	private String teamStatus;
	
}
//teamNo  	int PRIMARY KEY auto_increment,
//teamRegdate   timestamp DEFAULT NOW(),
//endDate   timestamp NULL,
//teamName   varchar(100)	NULL,
//teamGoal  	varchar(100)	NULL,
//userEmail  	varchar(50)	NULL