package com.weasy.admin.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.weasy.admin.awss3.AwsS3;
import com.weasy.admin.command.noticeListVO;
import com.weasy.admin.util.NoticeCriteria;

import lombok.RequiredArgsConstructor;

@Service("noticeService")
@RequiredArgsConstructor // amazonS3 null로 되지 않도록 달아줘야 함
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeMapper noticeMapper;

	private final AmazonS3 amazonS3;

	// 버킷명
	private String bucket = "weasy230314";

	@Override
	public ArrayList<noticeListVO> getNoticeList(NoticeCriteria cri) {

		return noticeMapper.getNoticeList(cri);
	}

	@Override
	public int getNoticeTotal() {

		return noticeMapper.getNoticeTotal();
	}

	@Override
	public int noticeRegist(noticeListVO vo) {

		return noticeMapper.noticeRegist(vo);
	}

	// 공지사항 insert 시 파일 처리
	@Override
	public int noticeFileRegist(MultipartFile multipartFile) {

		int result = -1;
		// 업로드 작업
		try {

			// 1. 멀티파트파일 -> 파일 타입 변환
			File file = convertMultipartFileToFile(multipartFile)
					.orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File convert fail"));

			// 2. 버킷에 업로드 - 두번쨰 매개변수가 버킷 내 저장할 디렉토리명
			AwsS3 aws_result = upload(file, "upload");

			// 3. 공지사항 파일 정보 테이블에 업로드
			result = noticeMapper.noticeFileRegist(aws_result.getPath(), noticeMapper.getNoticeNoMax());

		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}


		return result;
	}

	// 공지사항 update 시 파일 처리
	public int noticeFileRegist(MultipartFile multipartFile, int noticeNo) {

		int result = -1;
		// 업로드 작업
		try {

			// 1. 멀티파트파일 -> 파일 타입 변환
			File file = convertMultipartFileToFile(multipartFile)
					.orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File convert fail"));

			// 2. 버킷에 업로드 - 두번쨰 매개변수가 버킷 내 저장할 디렉토리명
			AwsS3 aws_result = upload(file, "upload");

			// 3. 공지사항 파일 정보 테이블에 업로드
			result = noticeMapper.noticeFileRegist(aws_result.getPath(), noticeNo);

		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 멀티파트 파일을 파일 타입으로 변환
	public Optional<File> convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
		File file = new File(System.getProperty("user.dir") + "/" + multipartFile.getOriginalFilename());

		if (file.createNewFile()) {
			try (FileOutputStream fos = new FileOutputStream(file)){
				fos.write(multipartFile.getBytes());
			}
			return Optional.of(file);
		}
		return Optional.empty();
	}

	// 경로 생성 및 업로드 호출
	private AwsS3 upload(File file, String dirName) {

		String key = dirName + "/"+ UUID.randomUUID() + file.getName();
		String path = putS3(file, key);
		removeFile(file);

		return AwsS3
				.builder()
				.key(key)
				.path(path)
				.build();

	}

	// 실제 s3 업로드 작업
	private String putS3(File uploadFile, String fileName) {

		amazonS3.putObject(new PutObjectRequest(bucket, fileName, uploadFile)
				.withCannedAcl(CannedAccessControlList.PublicRead));

		return getS3(bucket, fileName);
	}

	// 파일 uri 경로 리턴
	private String getS3(String bucket, String fileName) {
		return amazonS3.getUrl(bucket, fileName).toString();
	}

	private void removeFile(File file) {
		file.delete();
	}

	public void remove(AwsS3 awsS3) {
		if (!amazonS3.doesObjectExist(bucket, awsS3.getKey())) {
			throw new AmazonS3Exception("Object " +awsS3.getKey()+ " does not exist!");
		}
		amazonS3.deleteObject(bucket, awsS3.getKey());
	}

	// 공지사항 디테일 화면
	@Override
	public noticeListVO getNoticeDetail(int noticeNo) {

		return noticeMapper.getNoticeDetail(noticeNo);
	}
	
	// 공지사항 수정
	@Override
	public int noticeUpdate(noticeListVO vo) {

		return noticeMapper.noticeUpdate(vo);
	}
	
	// 공지사항 글 삭제
	@Override
	public int noticeDelete(int noticeNo) {
		
		return noticeMapper.noticeDelete(noticeNo);
	}

	// 공지사항 파일 정보 삭제
	@Override
	public int noticeFileDelete(int noticeNo) {

		return noticeMapper.noticeFileDelete(noticeNo);
	}

}
