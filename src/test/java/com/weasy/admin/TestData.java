package com.weasy.admin;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskVO;
import com.weasy.admin.service.BoardMapper;

@SpringBootTest
public class TestData {

	@Autowired
	BoardMapper boardMapper;

	@Test
	public void test01() {
		

//		for(int i=1; i<=103; i++) {
//			
//			TaskVO vo = TaskVO.builder()
//							  .taskNo(i)
//							  .title("업무"+i)
//							  .build();
//			
//			boardMapper.updateStatus(vo);
//			
//		}
		
		//		TaskVO vo1 = TaskVO.builder()
		//        .teamNo(i)
		//        .title("test")
		//        .startDate(new Timestamp(System.currentTimeMillis()+(60*60*24*1000)*i))
		//        .targetDate(new Timestamp(System.currentTimeMillis()+(60*60*24*1000)*i*20))
		//        .build();
		//
		//boardMapper.taskInsert(vo1);

//		for(int i=1; i<=103; i++) {
//			
//			TaskVO vo = TaskVO.builder()
//							  .taskNo(i)
//							  .status((int)(Math.random()*3)+1)
//							  .build();
//			
//			boardMapper.updateStatus(vo);
//			
//		}
		
		
	}


}
