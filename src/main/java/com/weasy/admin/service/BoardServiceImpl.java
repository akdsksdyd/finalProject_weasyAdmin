package com.weasy.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl {

	@Autowired
	private BoardMapper boardMapper;
	
}
