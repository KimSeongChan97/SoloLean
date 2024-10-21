package admin.service.impl;

import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import spring.conf.NCPConfiguration;
import admin.service.ObjectStorageService;

@Service  // Spring 서비스 클래스, 비즈니스 로직을 처리함
public class NCPObjectStorage implements ObjectStorageService {
   final AmazonS3 s3;
   
   // NCPObjectStorage 생성자: NCPConfiguration을 받아 S3 클라이언트를 초기화
   public NCPObjectStorage(NCPConfiguration naverConfiguration) {
      s3 = AmazonS3ClientBuilder
            .standard()
            .withEndpointConfiguration(
                  new AwsClientBuilder.
                        EndpointConfiguration(naverConfiguration.getEndPoint(), 
                                         naverConfiguration.getRegionName()))
            // AWS 자격증명(AccessKey와 SecretKey) 설정
            .withCredentials(new AWSStaticCredentialsProvider(
                           new BasicAWSCredentials(naverConfiguration.getAccessKey(), 
                                                 naverConfiguration.getSecretKey())
                           )
            )
            .build();  // AmazonS3 클라이언트 빌드
   }
   
   @Override
   public String uploadFile(String bucketName, String directoryPath, MultipartFile img) {
      try(InputStream inputStream = img.getInputStream()){  // MultipartFile에서 InputStream 얻기
         String imageFileName = UUID.randomUUID().toString();  // 파일 이름을 UUID로 생성하여 고유하게 설정
         // String imageFileName = img.getOriginalFilename(); // 원본 파일 이름으로 업로드할 경우 (선택 사항)
         
         // 파일 메타데이터 설정 (예: 파일의 Content-Type)
         ObjectMetadata objectMetadata = new ObjectMetadata();
         objectMetadata.setContentType(img.getContentType());  // 파일의 MIME 타입을 설정 (예: image/jpeg)
         
         // S3에 파일 업로드 요청 객체 생성
         PutObjectRequest putObjectRequest =
               new PutObjectRequest(bucketName,  // S3 버킷 이름
                                directoryPath + imageFileName,  // 업로드할 파일 경로 및 이름
                                inputStream,  // 업로드할 파일의 InputStream
                                objectMetadata)  // 파일의 메타데이터
               .withCannedAcl(CannedAccessControlList.PublicRead);  // 파일을 Public으로 읽을 수 있도록 권한 설정
               // CannedAccessControlList.PublicRead는 모든 사용자가 객체를 읽을 수 있지만, 수정과 삭제는 불가능함
         
         // S3에 파일 업로드
         s3.putObject(putObjectRequest);
         
         return imageFileName;  // 업로드된 파일의 이름을 반환
      }catch (Exception e) {
         // 파일 업로드 중 예외가 발생할 경우 RuntimeException을 발생시킴
         throw new RuntimeException("파일 업로드 에러");
      }
   }

   @Override
   public void deleteFile(String bucketName, String directoryPath, String imageFileName) {
      // S3에서 파일을 삭제
      s3.deleteObject(bucketName, directoryPath + imageFileName);  // 버킷과 파일 경로를 사용하여 삭제
   }

}
