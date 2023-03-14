package com.weasy.admin;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.amazonaws.services.s3.model.Bucket;
import com.weasy.admin.awss3.AwsS3;

@SpringBootTest
public class AWSTest {

	@Test
	public void test01() {
		
		AwsS3 awsS3 = AwsS3.getInstance();
		
		// C:\Users\이성호\Downloads
		File file = new File("C:\\Users\\이성호\\Downloads\\test.jpg");
		String key = "img/test1";
		String k = "dd";
		
		awsS3.upload(file, key);
		
		
	}
	
	
}
