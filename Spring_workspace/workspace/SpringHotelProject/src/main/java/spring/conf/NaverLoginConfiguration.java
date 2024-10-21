package spring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration  // Spring에서 이 클래스를 설정 파일로 사용함을 나타냄
@PropertySource("classpath:mysql/naverlogin.properties")  
// 외부 properties 파일을 불러와서 클래스 내에서 사용할 수 있도록 설정
// 여기서는 "mysql/naverlogin.properties" 파일에서 값을 가져옴

@Data  // Lombok을 사용하여 getter, setter 메서드를 자동으로 생성
public class NaverLoginConfiguration {
    
    // naver.clientID 값을 naverlogin.properties 파일에서 가져와서 clientID 필드에 주입
    public @Value("${naver.clientID}") String clientID;
    
    // naver.clientSecret 값을 naverlogin.properties 파일에서 가져와서 clientSecret 필드에 주입
    private @Value("${naver.clientSecret}") String clientSecret;
    
    // naver.redirectURI 값을 naverlogin.properties 파일에서 가져와서 redirectURI 필드에 주입
    private @Value("${naver.redirectURI}") String redirectURI;
    
    // 이 클래스는 네이버 로그인 API에 필요한 설정 정보를 담고 있음
    // clientID: 네이버 개발자 센터에서 발급받은 클라이언트 ID
    // clientSecret: 클라이언트 ID와 함께 사용되는 비밀 키
    // redirectURI: 네이버 로그인 인증 후 리다이렉션되는 URI
}
