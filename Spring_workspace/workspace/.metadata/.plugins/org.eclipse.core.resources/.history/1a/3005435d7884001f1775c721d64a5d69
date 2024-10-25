package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/* 
@Configuration: 이 클래스가 Spring의 설정 파일임을 나타냅니다. 
즉, Spring이 이 클래스를 보고 애플리케이션 설정을 자동으로 관리하게 됩니다. 
이 어노테이션은 XML 설정 파일을 대체할 수 있는 자바 기반 설정임을 나타냅니다.

@PropertySource("classpath:spring/db.properties"): 이 어노테이션은 외부 파일에 있는 프로퍼티(설정 값)를 로드하는 역할을 합니다. 
여기서는 "classpath:spring/db.properties" 경로에 있는 파일에서 JDBC 관련 설정 값(driver, url, username, password)을 불러옵니다.
프로퍼티 파일을 사용하면 코드와 설정을 분리할 수 있어 유지보수가 용이해집니다.
*/

@Configuration
@PropertySource("classpath:spring/db.properties")
public class SpringConfiguration {
		
	private @Value("${jdbc.driver}") String driver;
	private @Value("${jdbc.url}") String url;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;
	
	/*
	@Value("${jdbc.driver}"): 이 어노테이션은 외부 프로퍼티 파일에서 값을 불러와서 자바 필드에 주입하는 역할을 합니다.
	여기서는 "jdbc.driver", "jdbc.url", "jdbc.username", "jdbc.password" 키의 값을 각각 driver, url, username, password 변수에 할당합니다.
	즉, "spring/db.properties" 파일에 설정된 값이 이 변수에 주입됩니다.

	추가 설명:
	이 방식은 코드와 설정을 분리해주므로, 코드 변경 없이 환경 설정만 변경할 수 있습니다.
	예를 들어, 데이터베이스 정보가 바뀌면 코드 수정 없이 db.properties 파일만 수정하면 됩니다.
	*/
	
	@Bean
	public BasicDataSource dataSource(){
		/*
		@Bean: 이 메서드는 Spring 컨테이너에 빈(Bean)을 등록하는 역할을 합니다.
		즉, 이 메서드에서 반환되는 BasicDataSource 객체는 Spring 컨테이너에 의해 관리되며, 애플리케이션 내 다른 부분에서 이 빈을 주입받아 사용할 수 있습니다.
		Spring의 IoC(Inversion of Control) 컨테이너에서 관리하는 객체를 빈이라고 부릅니다.
		*/
		
		BasicDataSource basicDataSource = new BasicDataSource();
	    /*
	    BasicDataSource: Apache Commons DBCP에서 제공하는 데이터베이스 커넥션 풀을 관리하는 클래스입니다.
	    커넥션 풀은 애플리케이션이 데이터베이스와 연결할 때, 일정 수의 커넥션을 미리 만들어두고 재사용하는 메커니즘을 제공합니다.
	    이를 통해 데이터베이스 연결 성능을 크게 향상시킬 수 있습니다.
	    */

	    basicDataSource.setDriverClassName(driver);
	    /*
	    setDriverClassName(driver): MySQL 또는 다른 데이터베이스와 연결할 때 필요한 JDBC 드라이버의 클래스 이름을 설정합니다.
	    이 값은 외부 프로퍼티 파일에서 주입된 driver 변수의 값입니다. (예: com.mysql.cj.jdbc.Driver)
	    */

	    basicDataSource.setUrl(url);
	    /*
	    setUrl(url): 데이터베이스의 주소(URL)를 설정합니다.
	    외부에서 주입된 url 변수를 사용하여 MySQL 또는 다른 데이터베이스에 연결합니다.
	    예시: jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC
	    */

	    basicDataSource.setUsername(username);
	    /*
	    setUsername(username): 데이터베이스에 접근할 사용자 이름을 설정합니다.
	    외부 프로퍼티 파일에서 주입된 username 변수의 값을 사용하여 데이터베이스 사용자 이름을 설정합니다.
	    */

	    basicDataSource.setPassword(password);
	    /*
	    setPassword(password): 데이터베이스 접근 시 사용할 비밀번호를 설정합니다.
	    외부 프로퍼티 파일에서 주입된 password 변수의 값을 사용하여 데이터베이스 비밀번호를 설정합니다.
	    */

	    return basicDataSource;
	    /*
	    기본적으로 BasicDataSource 객체를 생성하고 설정을 완료한 후, 이 객체를 반환합니다.
	    이 반환된 객체는 Spring 컨테이너에 의해 관리되고, 다른 빈에서 의존성 주입을 통해 이 데이터를 사용할 수 있습니다.
	    */
	}
}