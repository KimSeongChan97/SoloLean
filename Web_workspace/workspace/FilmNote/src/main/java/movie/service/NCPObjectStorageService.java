// FilmNote/src/main/java/movie/service/NCPObjectStorageService.java
package movie.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class NCPObjectStorageService {

	// 나중에 db.properties 로 옮겨야함
	private String accessKey = "ncp_iam_BPASKR3lAMp6wZFxwiCN"; 
	private String secretKey = "ncp_iam_BPKSKRE7SxoGD1gBMfi9EMviOe5H5Qru6g";
	private String regionName = "kr-standard";
	private String endPoint = "https://kr.object.ncloudstorage.com";
	private String bucketName = "filmnote-bucket-116";
	
	final AmazonS3 s3;
	
	public NCPObjectStorageService() {
		s3 = AmazonS3ClientBuilder
				.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
				.build();
	}

	public String uploadFile(String bucketName, String directoryPath, File file) {
		// String fileName = file.getName(); - public void
		
		String fileName = UUID.randomUUID().toString(); 
		// UUID : 숫자 형식으로 파일명을 만들어줌; 같은 파일명을 올려도 다른 이름으로 계속 올라감 return String
		
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		/* 정보 파일 잡기 */
		ObjectMetadata objectMetadata = new ObjectMetadata();
		// objectMetadata.setContentType("image/jpeg"); 이러면 귀찮음 for 문 써줘야함
		
		Path path = Paths.get(file.getAbsolutePath());
		String contentType = null;
		try {
			contentType = Files.probeContentType(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		objectMetadata.setContentType(contentType);
		objectMetadata.setContentLength(file.length());
		
		// putObjectRequest 생성해서 bucketName 에 directoryPath + fileName 이름으로 파일 불러들임
		PutObjectRequest putObjectRequest = 
				new PutObjectRequest(bucketName,
									directoryPath + fileName,
									fileIn,
									objectMetadata)
				.withCannedAcl(CannedAccessControlList.PublicRead);
				// Acl : 리소스에 대한 접근 권한
				// 모든 사용자가 객체를 읽을 수 있지만, 수정과 삭제는 불가능
		
		s3.putObject(putObjectRequest); // Object에 올리기
		
		return fileName;
		
	}
	
	public void deleteFile(String fileName) {
	    try {
	        s3.deleteObject(bucketName, "storage/" + fileName);
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	}
	
}
