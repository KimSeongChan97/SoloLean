package user.service.impl;

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

import spring.conf.NaverConfiguration;
import user.service.ObjectStorageService;

@Service
public class NCPObjectStorageService implements ObjectStorageService {
    // Amazon S3 클라이언트 객체를 final로 선언하여 변경되지 않도록 설정
    final AmazonS3 s3;

    // NaverConfiguration 클래스에서 AWS S3와 관련된 설정값을 주입받아 S3 클라이언트를 초기화
    public NCPObjectStorageService(NaverConfiguration naverConfiguration) {
        // AmazonS3 클라이언트 빌더로 설정을 구성
        s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                            naverConfiguration.getEndPoint(),  // 네이버 클라우드의 엔드포인트를 가져옴
                            naverConfiguration.getRegionName()))  // 리전(지역) 이름을 가져옴
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                    naverConfiguration.getAccessKey(),  // 액세스 키를 가져옴
                                    naverConfiguration.getSecretKey())))  // 시크릿 키를 가져옴
                .build();  // Amazon S3 클라이언트 객체를 생성
    }

    // S3 버킷에 파일 업로드 메서드 구현
    @Override
    public String uploadFile(String bucketName, String directoryPath, MultipartFile img) {
        // try-with-resources 구문을 사용해 InputStream을 자동으로 닫도록 설정
        try (InputStream inputStream = img.getInputStream()) {
            // UUID를 사용하여 고유한 파일 이름을 생성
            String imageFileName = UUID.randomUUID().toString();  // 고유한 파일 이름 생성

            // ObjectMetadata 객체 생성 및 메타데이터 설정
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(img.getSize());  // 파일 크기를 메타데이터에 설정
            objectMetadata.setContentType(img.getContentType());  // 파일의 Content-Type을 설정 (예: image/png, image/jpeg)

            // S3 업로드를 위한 PutObjectRequest 객체 생성
            PutObjectRequest putObjectRequest = 
                new PutObjectRequest(bucketName,  // 업로드할 버킷 이름
                                     directoryPath + imageFileName,  // 저장할 파일 경로와 이름
                                     inputStream,  // 파일 데이터 스트림
                                     objectMetadata)  // 파일 메타데이터
                .withCannedAcl(CannedAccessControlList.PublicRead);  // 파일을 퍼블릭 읽기 권한으로 설정하여 외부 접근 허용

            // S3에 파일 업로드 요청
            s3.putObject(putObjectRequest);  // S3에 파일을 업로드

            // 업로드된 파일의 고유한 이름을 반환
            return imageFileName;  // S3에 업로드된 파일의 이름을 반환
        } catch (Exception e) {
            // 파일 업로드 중 예외가 발생하면 런타임 예외로 처리
            throw new RuntimeException("파일 업로드 에러");  // 업로드 중 예외가 발생하면 에러를 던짐
        }
    }
}
