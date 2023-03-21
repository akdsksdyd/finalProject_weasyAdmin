package com.weasy.admin;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weasy.admin.command.AuthorityVO;
import com.weasy.admin.command.TaskDetailVO;
import com.weasy.admin.command.TaskVO;
import com.weasy.admin.service.BoardMapper;
import com.weasy.admin.service.NoticeMapper;

@SpringBootTest
public class TestData {

	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	NoticeMapper noticeMapper;
	
	// 샘플데이터용
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
		
		
		
//		for(int i=1; i<=11; i++) {
//			
//			int n = (int)(Math.random()*5)+4;
//			
//			for(int j=1; j<=n; j++) {
//				AuthorityVO vo = AuthorityVO.builder()
//											.userEmail("user"+j)
//											.teamNo(i)
//											.role( j==n ? 1 : 0)
//											.build();
//				boardMapper.setAuthority(vo);
//			}
//		}
		
	}

	// notice 테스트
	@Test
	public void test02() {
		
		String[] arr = noticeMapper.getFilePath(40);
		
		for(String path : arr) {
			System.out.println(path.split("amazonaws.com/")[1]);
		}
		
	}
	
}
