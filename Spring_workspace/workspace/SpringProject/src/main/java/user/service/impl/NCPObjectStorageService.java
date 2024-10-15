package user.service.impl;

import java.io.InputStream;
import java.util.List;
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
    // final 키워드는 이 변수 값이 한 번 할당된 후 변경되지 않음을 보장합니다.
    final AmazonS3 s3;

    // NaverConfiguration 클래스에서 AWS S3와 관련된 설정값을 주입받아 S3 클라이언트를 초기화
    // 생성자를 통해 NaverConfiguration 객체를 주입받아 사용합니다. 이 객체는 설정 정보를 담고 있습니다.
    public NCPObjectStorageService(NaverConfiguration naverConfiguration) {
        // AmazonS3 클라이언트 빌더로 설정을 구성
        // AmazonS3ClientBuilder는 Amazon S3와의 연결을 설정하고, 이를 통해 클라이언트 객체를 만듭니다.
        s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                            naverConfiguration.getEndPoint(),  // 네이버 클라우드의 엔드포인트를 가져옴
                            naverConfiguration.getRegionName()))  // 리전(지역) 이름을 가져옴
                            // EndpointConfiguration은 AWS 리전 및 서비스에 대한 엔드포인트 정보를 설정합니다.
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                    naverConfiguration.getAccessKey(),  // 액세스 키를 가져옴
                                    naverConfiguration.getSecretKey())))  // 시크릿 키를 가져옴
                                    // AWSStaticCredentialsProvider는 인증 정보를 제공합니다. 여기서는 액세스 키와 시크릿 키를 사용합니다.
                .build();  // Amazon S3 클라이언트 객체를 생성
                // build() 메서드는 모든 설정을 토대로 S3 클라이언트 객체를 생성합니다.
    }

    // S3 버킷에 파일 업로드 메서드 구현
    // 파일을 AWS S3 버킷에 업로드하고, 해당 파일의 이름(경로 포함)을 반환하는 메서드입니다.
    @Override
    public String uploadFile(String bucketName, String directoryPath, MultipartFile img) {
        // try-with-resources 구문을 사용해 InputStream을 자동으로 닫도록 설정
        // try-with-resources 구문은 자원을 자동으로 해제하는 기능을 제공하는데, 여기서는 InputStream을 자동으로 닫습니다.
        try (InputStream inputStream = img.getInputStream()) {
            // UUID를 사용하여 고유한 파일 이름을 생성
            // UUID는 각 파일마다 고유한 식별자를 생성하기 위한 표준 방법입니다.
            String imageFileName = UUID.randomUUID().toString();  // 고유한 파일 이름 생성
            // UUID.randomUUID()는 고유한 값을 생성하여 파일 이름이 중복되지 않도록 해줍니다.

            // ObjectMetadata 객체 생성 및 메타데이터 설정
            // 메타데이터는 파일에 대한 추가적인 정보를 저장합니다. 여기서는 파일 크기와 파일 타입을 저장합니다.
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(img.getSize());  // 파일 크기를 메타데이터에 설정
            objectMetadata.setContentType(img.getContentType());  // 파일의 Content-Type을 설정 (예: image/png, image/jpeg)
            // setContentLength는 파일의 바이트 크기를 설정하며, setContentType은 파일의 MIME 타입을 설정합니다.
            
            // S3 업로드를 위한 PutObjectRequest 객체 생성
            // PutObjectRequest는 AWS S3에 파일을 업로드할 때 필요한 모든 정보를 담고 있는 객체입니다.
            PutObjectRequest putObjectRequest = 
                new PutObjectRequest(bucketName,  // 업로드할 버킷 이름
                                     directoryPath + imageFileName,  // 저장할 파일 경로와 이름
                                     inputStream,  // 파일 데이터 스트림
                                     objectMetadata)  // 파일 메타데이터
                .withCannedAcl(CannedAccessControlList.PublicRead);  // 파일을 퍼블릭 읽기 권한으로 설정하여 외부 접근 허용
                // CannedAccessControlList.PublicRead는 파일에 대해 공개 읽기 권한을 설정합니다.
                // 이를 통해 외부에서 해당 파일에 접근할 수 있게 됩니다.

            // S3에 파일 업로드 요청
            // putObject 메서드는 S3에 파일을 업로드하는 작업을 수행합니다.
            s3.putObject(putObjectRequest);  // S3에 파일을 업로드

            // 업로드된 파일의 고유한 이름을 반환
            // 업로드된 파일의 이름(고유 ID)을 반환하여 이후에 이 파일에 접근할 때 사용됩니다.
            return imageFileName;  // S3에 업로드된 파일의 이름을 반환
        } catch (Exception e) {
            // 파일 업로드 중 예외가 발생하면 런타임 예외로 처리
            // 예외가 발생하면 이를 처리하고, 업로드 실패를 알리는 메시지를 던집니다.
            throw new RuntimeException("파일 업로드 에러");  // 업로드 중 예외가 발생하면 에러를 던짐
            // RuntimeException은 실행 중에 발생한 예외를 처리하기 위한 기본 예외 클래스입니다.
        }
    }
    
 // S3 버킷에서 파일을 삭제하는 메서드 구현
    @Override
    public void deleteFile(String bucketName, String directoryPath, String imageFileName) {
        // S3에서 특정 버킷의 경로에 있는 파일을 삭제합니다.
        // bucketName은 AWS S3에서 사용되는 버킷 이름을 의미합니다. 
        // 버킷은 S3에서 파일을 저장하는 일종의 "컨테이너" 같은 개념입니다.
        // directoryPath는 파일이 저장된 디렉토리 경로를 나타냅니다. 
        // S3에서는 파일을 계층 구조로 저장할 수 있기 때문에 경로가 포함됩니다.
        // imageFileName은 삭제하고자 하는 파일의 이름입니다.
        
        s3.deleteObject(bucketName, directoryPath + imageFileName);
        // s3.deleteObject()는 AWS S3 클라이언트가 제공하는 메서드로, 
        // 해당 버킷의 특정 경로에 있는 파일을 삭제하는 역할을 합니다.
        // 이 메서드는 첫 번째 인자로 버킷 이름을, 두 번째 인자로 삭제할 파일의 경로를 받습니다.
        // directoryPath + imageFileName은 경로와 파일 이름을 결합한 것으로,
        // S3에 저장된 파일의 정확한 위치를 나타냅니다.
        
        // deleteObject 메서드는 주어진 버킷과 경로에서 파일을 삭제하는 기능을 합니다
        // 이 메서드를 호출하면 S3에서 해당 파일이 삭제되고, 성공 시 특별한 반환값은 없습니다.
        // 삭제 후에는 더 이상 해당 파일을 S3에서 찾을 수 없습니다.
    }

    // S3 버킷에서 파일을 삭제하는 메서드 구현
    @Override
    public void deleteFile(String bucketName, String directoryPath, List<String> list) {
        // 이 메서드는 여러 개의 파일을 한꺼번에 삭제할 수 있도록 리스트를 인자로 받습니다.
        // 첫 번째 인자인 bucketName은 삭제하고자 하는 파일들이 속해 있는 S3 버킷 이름입니다.
        // 두 번째 인자인 directoryPath는 파일들이 저장된 경로를 의미하며,
        // S3의 특정 경로에 있는 파일들을 모두 삭제할 수 있습니다.
        // 세 번째 인자인 list는 삭제하고자 하는 파일 이름들의 리스트입니다.
        
        for (String imageFileName : list) {
            // 리스트에 있는 각 파일 이름을 하나씩 순회하면서 삭제 작업을 수행합니다.
            // for-each 문을 사용하여 리스트 안에 있는 파일 이름들을 하나씩 꺼냅니다.
            
            s3.deleteObject(bucketName, directoryPath + imageFileName);
            // 이 부분은 위의 메서드와 동일한 deleteObject 메서드를 사용합니다.
            // 리스트 안에 있는 각 파일 이름에 대해 S3의 해당 경로에서 삭제 작업을 수행합니다.
            // directoryPath와 imageFileName을 합쳐서 해당 파일의 전체 경로를 만들고,
            // S3에서 그 파일을 삭제합니다.
        }
        
        // 전체적으로 이 메서드는 여러 파일을 리스트 형태로 받아서 순차적으로 S3에서 삭제하는 역할을 합니다.
        // 리스트에 있는 모든 파일이 삭제될 때까지 for-each 문이 반복됩니다.
    }

    
}
