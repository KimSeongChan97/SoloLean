package spring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySource("classpath:spring/naver.properties")
@Getter
@Setter
public class NaverConfiguration {
   private @Value("${ncp.accessKey}") String accessKey; //접근할 수 있는 키값
   private @Value("${ncp.secretKey}") String secretKey; //보안 키값
   private @Value("${ncp.regionName}") String regionName;
   private @Value("${ncp.endPoint}") String endPoint;
}
