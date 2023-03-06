package com.weasy.admin.util;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PageVO {
	
	private int start; 
	private int end; 
	private boolean prev; 
	private boolean next; 
	
	private int pageCount =  10; //페이지네이션 개수
	
	private int page; 
	private int amount; 
	private int total; 
	private int realEnd; 
	
	private Criteria cri;
	private ArrayList<Integer> pageList; //
	
	public PageVO(Criteria cri, int total) {
		this.page = cri.getPage();
		this.amount = cri.getAmount();
		this.total = total;
		this.cri = cri;
		
		this.end = (int)Math.ceil(this.page/(double)pageCount) * pageCount;
		
		this.start = this.end - pageCount + 1;
		
		this.realEnd = (int)Math.ceil(total / (double)this.amount);
		
		this.end = this.end > this.realEnd ? this.realEnd : this.end;
		
		this.prev = this.start >1;
		
		this.next = this.realEnd >this.end;
		
		this.pageList = new ArrayList<>();
		for(int i = this.start; i<= this.end; i++) {
			pageList.add(i);
		}
		
		
	}
}
