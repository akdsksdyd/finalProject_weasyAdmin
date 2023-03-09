package com.weasy.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.service.TeamMapper;

@SpringBootTest
public class TeamTest {
	
	@Autowired
	TeamMapper teamMapper;
	

}
