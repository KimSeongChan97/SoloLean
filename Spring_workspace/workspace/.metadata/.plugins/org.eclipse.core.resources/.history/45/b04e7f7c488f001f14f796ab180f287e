package spring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource("classpath:mysql/naverlogin.properties")
@Data
public class NaverLoginConfiguration {
	public @Value("${naver.clientID}") String clientID;
	private @Value("${naver.clientSecret}") String clientSecret;
	private @Value("${naver.redirectURI}") String redirectURI;
}