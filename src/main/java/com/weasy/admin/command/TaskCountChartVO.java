package com.weasy.admin.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskCountChartVO {
	// 태스크 수 상위 3팀
	private int teamNo;
	private int total;
	private String teamName;
	
}
