package com.weasy.admin.util;

import lombok.Data;

@Data
public class NoticeCriteria {

	// sql에 전달할 page, amount를 가지고 다니는 클래스
	private int page; // 조회하는 페이지 번호
	private int amount; // 데이터 개수

	// 검색 키워드 - 제목 또는 내용
	private String searchText;

	public NoticeCriteria() {
		this.page = 1;
		this.amount = 10;
	}

	public NoticeCriteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}

	public int getPageStart() {
		return (page - 1) * amount;
	}

}
