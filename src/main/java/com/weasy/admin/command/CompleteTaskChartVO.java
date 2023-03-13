package com.weasy.admin.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompleteTaskChartVO {
	
	// 완료 태스크 완료 수 상위 3팀
	private int complete;
	private int teamNo;
	private String teamName;
	
}
