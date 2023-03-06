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
	
	

}
