package com.weasy.admin.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskProgressVO {
	
	private String teamName;
	private int teamNo;
	private int progress;
	private int unprogress;
	private int complete;
	
}
