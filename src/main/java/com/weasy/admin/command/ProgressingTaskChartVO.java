package com.weasy.admin.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgressingTaskChartVO {
	
	// 진행중인 태스크 수 상위 4팀
	private int progressing;
	private int teamNo;
	private String teamName;
	
}
