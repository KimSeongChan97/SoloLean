package admin.service;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageService {

    // 파일 삭제
    public void deleteFile(String bucketName, String filePath, String imageFileName);  
    // bucketName: S3와 같은 오브젝트 스토리지의 버킷 이름을 의미
    // filePath: 파일이 저장된 경로(폴더 구조를 의미)
    // imageFileName: 삭제할 파일(이미지)의 이름
    // 주어진 버킷과 경로에서 해당 이미지 파일을 삭제하는 역할을 함

    // 파일 업로드
    public String uploadFile(String bucketName, String filePath, MultipartFile img);  
    // bucketName: 파일을 업로드할 버킷 이름
    // filePath: 파일이 저장될 경로 (폴더 구조를 의미)
    // img: 업로드할 파일, MultipartFile로 받음
    // 주어진 버킷과 경로에 파일을 업로드하고, 업로드된 파일의 URL 혹은 경로를 반환
}

