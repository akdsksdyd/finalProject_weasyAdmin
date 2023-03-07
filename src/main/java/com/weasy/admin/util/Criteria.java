package com.weasy.admin.util;

import lombok.Data;

@Data
public class Criteria {
	
	private int page; 
	private int amount; 
	
	public Criteria() {
		this.page = 1;
		this.amount = 10;
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
	private String searchName; // 상품명
	private String searchContent; // 상품내용
	private String searchPrice; // 정렬방식
	private String startDate; // 판매 시작일
	private String endDate; // 판매 종료일

}
