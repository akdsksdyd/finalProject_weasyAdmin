package com.weasy.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsS3Config {

	@Value("${project.aws_accessKey}")
	private String aws_accessKey;
	
	@Value("${project.aws_secretAccessKey}")
	private String aws_secretAccessKey;
	
	@Value("${project.aws_region}")
	private String region;
	
	@Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials(aws_accessKey, aws_secretAccessKey);
    }

    @Bean
    public AmazonS3 amazonS3(BasicAWSCredentials basicAWSCredentials) {
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }
	
}
