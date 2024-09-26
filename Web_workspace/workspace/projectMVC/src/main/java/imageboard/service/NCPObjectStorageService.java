package imageboard.service;

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

public class NCPObjectStorageService  {
	private String accessKey = "MY_KEY"; // 개인 키 이므로 추후 프로퍼티 를 통해 보안성강화가 필요 // ncp_iam_BPASKR1rkHdM4GZvZUXw
	private String secretKey = "MY_KEY"; // 개인 키 이므로 추후 프로퍼티 를 통해 보안성강화가 필요 // ncp_iam_BPKSKRCJwDshvcUw4ZcyZ35rLxtxCmmYEY
	private String regionName = "kr-standard";
	private String endPoint = "https://kr.object.ncloudstorage.com";
	
	final AmazonS3 s3;
	
	public NCPObjectStorageService() {
		s3 = AmazonS3ClientBuilder
								.standard()
								.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
								.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
								.build();
	}

	public String uploadFile(String bucketName, String directoryPath, File file) {
		//String fileName = file.getName();
		String fileName = UUID.randomUUID().toString();
		
		FileInputStream fileIn = null;
        try {
			fileIn = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        ObjectMetadata objectMetadata = new ObjectMetadata();
         // objectMetadata.setContentType("image/jpg");
        Path path = Paths.get(file.getAbsolutePath());
        String contentType = null;
        try {
			contentType = Files.probeContentType(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        objectMetadata.setContentType(contentType);
        objectMetadata.setContentLength(file.length());
        
        PutObjectRequest putObjectRequest =
        				new PutObjectRequest(bucketName,
        									directoryPath + fileName,
        									fileIn,
        									objectMetadata)
        				.withCannedAcl(CannedAccessControlList.PublicRead); // 리소스에 대한 접근 권한
        				// PublicRead 는 모든 사용자가 객체를 읽을 수 있지만 수정과 삭제는 불가능하다
        
        s3.putObject(putObjectRequest); // 올리기
        
        return fileName;
	}
	
}
