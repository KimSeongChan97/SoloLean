package spring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration  // 이 클래스는 Spring에서 설정 클래스로 사용됨을 나타냄
@PropertySource("classpath:mysql/ncp.properties")  
// "ncp.properties" 파일에 정의된 값들을 불러와 이 클래스에서 사용 가능하도록 설정
// properties 파일 경로는 "classpath:mysql/ncp.properties"로 설정됨

@Getter  // Lombok을 이용하여 getter 메서드를 자동으로 생성 (모든 필드에 대해 getter 제공)
@Setter  // Lombok을 이용하여 setter 메서드를 자동으로 생성 (모든 필드에 대해 setter 제공)
public class NCPConfiguration {

   // "ncp.accessKey" 값을 ncp.properties 파일에서 가져와 accessKey 필드에 주입
   private @Value("${ncp.accessKey}") String accessKey; 
   // 접근 권한을 확인할 수 있는 키값 (API 인증용)

   // "ncp.secretKey" 값을 ncp.properties 파일에서 가져와 secretKey 필드에 주입
   private @Value("${ncp.secretKey}") String secretKey;
   // 비밀 키 (API 보안용)

   // "ncp.regionName" 값을 ncp.properties 파일에서 가져와 regionName 필드에 주입
   private @Value("${ncp.regionName}") String regionName; 
   // NCP(네이버 클라우드 플랫폼) 서비스가 운영되는 지역 이름 (예: ap-northeast-2)

   // "ncp.endPoint" 값을 ncp.properties 파일에서 가져와 endPoint 필드에 주입
   private @Value("${ncp.endPoint}") String endPoint;
   // API 요청을 처리할 엔드포인트 URL (네이버 클라우드의 API 서비스 URL)

}
