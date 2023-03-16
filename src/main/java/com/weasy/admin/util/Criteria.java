package com.weasy.admin.util;

import lombok.Data;

@Data
public class Criteria {
	
	private int page; 
	private int amount; 
	private String teamStatus;
	private String category;
	private String keyword;
	private String teamSort;
	
	public Criteria() {
		this.page = 1;
		this.amount = 10;
		this.teamStatus = "";
	}

	public Criteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (page - 1) * amount;
	}
	
	// 검색 키워드
	private String searchName; 
	private String searchContent; 
	private String searchPrice; 
	private String startDate; 
	private String endDate; 
	private String searchEmail;
	

}
