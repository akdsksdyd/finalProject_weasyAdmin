//package com.weasy.admin;
//
//import java.sql.Timestamp;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.weasy.admin.command.UserVO;
//import com.weasy.admin.service.UserMapper;
//
//@SpringBootTest
//public class UserTest {
//	
//	@Autowired
//	UserMapper userMapper;
//	
//	@Test
//	public void UserTest() {
//		
//		for(int i=1; i<300; i++) {
//			
//			UserVO vo = UserVO.builder()
//							.userName("admin")
//							.userEmail(i + i + i + "@gmail.com")
//							.phoneNum("010 - " + i*1000 + "-" + i*1000)
//							.birth(980123)
//							.gender("F")
//							.nickname("KERRIII" + i )
//							.loginDate(new Timestamp(System.currentTimeMillis()))
//							.build();
//			
//			userMapper.userRegist(vo);
//		}
//	}
//
//}
