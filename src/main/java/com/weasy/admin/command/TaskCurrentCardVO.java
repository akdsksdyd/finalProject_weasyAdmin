package com.weasy.admin.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskCurrentCardVO {
	
	private int teamNo;
	private String teamName;
	private int progress;
	private int unprogress;
	private int complete;
	private int taskCount;
	private int teamCount;
	private int remain;
	
}
