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

    // 나중에 db.properties 파일로 옮길 필요가 있는 민감 정보 (액세스 키, 시크릿 키, 지역 이름, 엔드포인트, 버킷 이름)
    private String accessKey = "ncp_iam_BPASKR3lAMp6wZFxwiCN"; // 네이버 클라우드 플랫폼 IAM 액세스 키
    private String secretKey = "ncp_iam_BPKSKRE7SxoGD1gBMfi9EMviOe5H5Qru6g"; // 네이버 클라우드 플랫폼 IAM 시크릿 키
    private String regionName = "kr-standard"; // NCP 오브젝트 스토리지의 표준 지역 이름
    private String endPoint = "https://kr.object.ncloudstorage.com"; // NCP 오브젝트 스토리지의 엔드포인트 URL
    private String bucketName = "filmnote-bucket-116"; // 사용할 S3 버킷 이름
    
    final AmazonS3 s3; // AmazonS3 객체로 NCP 오브젝트 스토리지와 상호작용하는 클라이언트

    // 생성자에서 NCP 오브젝트 스토리지 클라이언트 초기화
    public NCPObjectStorageService() {
        s3 = AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build(); // S3 클라이언트 빌더를 통해 설정된 클라이언트 생성
    }

    /**
     * NCP 오브젝트 스토리지에 파일을 업로드하는 메서드
     *
     * @param bucketName S3 버킷 이름
     * @param directoryPath 파일을 저장할 디렉토리 경로
     * @param file 업로드할 파일 객체
     * @return 저장된 파일의 고유 파일 이름(UUID로 생성)
     */
    public String uploadFile(String bucketName, String directoryPath, File file) {
        // 파일 이름을 랜덤한 UUID로 생성
        String fileName = UUID.randomUUID().toString();
        // UUID : 고유한 파일명을 만들어주기 때문에 같은 이름의 파일을 여러 번 업로드할 때 충돌 방지

        // 파일을 읽기 위한 FileInputStream 생성
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // 파일이 존재하지 않을 때 예외 처리
        }

        /* 파일의 메타데이터 설정 (파일 타입 및 크기) */
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 파일의 MIME 타입을 결정
        Path path = Paths.get(file.getAbsolutePath());
        String contentType = null;
        try {
            contentType = Files.probeContentType(path); // 파일의 MIME 타입 추출
        } catch (IOException e) {
            e.printStackTrace();
        }

        objectMetadata.setContentType(contentType); // 추출된 MIME 타입 설정
        objectMetadata.setContentLength(file.length()); // 파일의 크기를 메타데이터에 설정

        // PutObjectRequest를 통해 파일을 S3 버킷에 업로드
        PutObjectRequest putObjectRequest = 
                new PutObjectRequest(bucketName,
                                    directoryPath + fileName,
                                    fileIn,
                                    objectMetadata)
                .withCannedAcl(CannedAccessControlList.PublicRead); 
                // withCannedAcl() : 파일에 대한 접근 권한을 설정 (여기서는 PublicRead로 설정하여 누구나 읽을 수 있게 함)

        s3.putObject(putObjectRequest); // 파일을 오브젝트 스토리지에 업로드

        return fileName; // 저장된 파일의 고유 이름 반환
    }

    /**
     * NCP 오브젝트 스토리지에서 파일을 삭제하는 메서드
     *
     * @param fileName 삭제할 파일 이름
     */
    public void deleteFile(String fileName) {
        try {
            s3.deleteObject(bucketName, "storage/" + fileName); // 버킷에서 파일 삭제
        } catch (Exception e) {
            e.printStackTrace(); // 파일 삭제 중 예외 발생 시 처리
        }
    }
}
