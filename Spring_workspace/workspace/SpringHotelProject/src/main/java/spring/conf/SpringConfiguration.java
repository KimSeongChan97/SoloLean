package spring.conf;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  // 이 클래스가 Spring의 설정 클래스임을 나타냄
@EnableTransactionManagement  // 트랜잭션 관리를 활성화
@PropertySource("classpath:mysql/db.properties")  
// 외부의 db.properties 파일에서 설정 값을 가져와서 사용할 수 있게 함
@MapperScan("*.dao")  
// MyBatis의 Mapper 인터페이스를 스캔하여 매핑된 SQL을 자동으로 실행할 수 있도록 설정
public class SpringConfiguration {

   // db.properties 파일에서 값 주입
   private @Value("${jdbc.driver}") String driver;  // 데이터베이스 드라이버
   private @Value("${jdbc.url}") String url;  // 데이터베이스 연결 URL
   private @Value("${jdbc.username}") String username;  // 데이터베이스 사용자 이름
   private @Value("${jdbc.password}") String password;  // 데이터베이스 사용자 비밀번호
   
   @Autowired
   private ApplicationContext context;  // Spring 컨텍스트로부터 설정된 Bean들을 가져올 수 있게 함
   
   @Bean
   public BasicDataSource dataSource() {
      // 데이터베이스 연결에 필요한 DataSource 설정
      BasicDataSource basicDataSource =  new BasicDataSource();
      basicDataSource.setDriverClassName(driver);  // JDBC 드라이버 클래스 설정
      basicDataSource.setUrl(url);  // 데이터베이스 URL 설정
      basicDataSource.setUsername(username);  // 데이터베이스 사용자 이름 설정
      basicDataSource.setPassword(password);  // 데이터베이스 사용자 비밀번호 설정
      return basicDataSource;  // 설정된 DataSource 반환
   }
   
   @Bean
   public SqlSessionFactory sqlSessionFactory() throws Exception {
      // MyBatis의 SqlSessionFactory 설정
      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
      sqlSessionFactoryBean.setDataSource(dataSource());  // DataSource를 설정
      sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mysql/mybatis-config.xml"));
      // MyBatis의 설정 파일 위치 지정 (mybatis-config.xml)

      // Mapper 파일 위치 설정: MyBatis에서 SQL을 매핑할 XML 파일들의 위치를 설정
      sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mapper/*Mapper.xml"));
      // 여러 개의 Mapper 파일을 설정할 수 있음

      // TypeAliasesPackage는 MyBatis가 특정 패키지에 있는 클래스를 매핑할 때 사용할 수 있는 별칭을 설정
      sqlSessionFactoryBean.setTypeAliasesPackage("*.bean");
      
      return sqlSessionFactoryBean.getObject();  // SqlSessionFactory 객체 생성 및 반환
   }
   
   @Bean
   public SqlSessionTemplate sqlSession() throws Exception {
      // SqlSessionTemplate 설정 (MyBatis에서 SQL을 실행할 때 사용)
      SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
      return sqlSessionTemplate;  // SqlSessionTemplate 객체 반환
   }
   
   @Bean
   public DataSourceTransactionManager transactionManager(){
      // 트랜잭션 관리자를 설정
      DataSourceTransactionManager dataSourceTransactionManager = 
            new DataSourceTransactionManager(dataSource());
      return dataSourceTransactionManager;  // 트랜잭션 관리자를 반환
   }
   
   @PostConstruct  // 이 메서드는 Bean이 초기화된 후 호출됨
   public void init() {
       // TLS 프로토콜 설정
       // 보안 통신에 사용되는 프로토콜을 TLSv1.2로 강제 설정
       System.setProperty("https.protocols", "TLSv1.2");
   }
}
