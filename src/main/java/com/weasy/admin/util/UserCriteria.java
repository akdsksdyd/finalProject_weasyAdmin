package com.weasy.admin.util;

import lombok.Data;

@Data
public class UserCriteria {

	//SQL에 전달할 page, amount 을 가지고 다니는 클래스
	private int page; //조회하는페이지번호
	private int amount; //데이터개수

	//검색키워드
	private String searchName; //이름검색
	private String searchEmail; //이메일검색
	
	public UserCriteria() {
		this.page = 1;
		this.amount = 10;
	}

	public UserCriteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (page - 1) * amount;
	}
}
