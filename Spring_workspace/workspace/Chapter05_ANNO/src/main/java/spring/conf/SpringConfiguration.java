package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement  // 이 어노테이션은 @Transactional을 사용하여 선언적 트랜잭션 관리를 활성화하는 역할을 합니다.
// @Transactional을 사용하면 개발자가 직접 트랜잭션 시작/종료/롤백 등을 처리할 필요 없이 선언적으로 트랜잭션을 관리할 수 있습니다.
@Configuration  // 이 어노테이션은 Spring 설정 클래스임을 나타냅니다. XML이 아닌 자바 클래스로 설정을 관리할 때 사용합니다.
// XML 기반의 설정 대신 자바 클래스로 스프링 빈을 설정하고 관리하기 위한 어노테이션입니다.
@PropertySource("classpath:spring/db.properties")  // 외부 properties 파일에서 DB 연결 정보를 불러오기 위해 사용됩니다.
// 외부 파일에서 DB 설정 정보(드라이버, URL, 사용자명, 비밀번호)를 불러와서 재사용할 수 있게 해줍니다. 유지보수가 용이합니다.
public class SpringConfiguration {

    // @Value 어노테이션은 properties 파일에서 값을 읽어올 때 사용됩니다. db.properties 파일에서 각각의 값(driver, url, username, password)을 가져옵니다.
    // @Value는 설정 파일의 키 값을 어노테이션의 필드에 주입해주는 역할을 합니다.
    private @Value("${jdbc.driver}") String driver;  // jdbc.driver 속성을 db.properties 파일에서 가져옴
    private @Value("${jdbc.url}") String url;  // jdbc.url 속성을 db.properties 파일에서 가져옴
    private @Value("${jdbc.username}") String username;  // jdbc.username 속성을 db.properties 파일에서 가져옴
    private @Value("${jdbc.password}") String password;  // jdbc.password 속성을 db.properties 파일에서 가져옴

    // DB와 연결하기 위한 DataSource를 설정합니다. 
    // BasicDataSource는 DBCP2(Connection Pooling)를 사용하여 DB 연결을 관리합니다. 커넥션 풀은 여러 DB 연결을 미리 만들어두고 필요할 때 재사용하는 방식으로 성능을 높입니다.
    // DataSource는 DB와의 연결을 관리하는 핵심 클래스입니다. 커넥션 풀링을 통해 다수의 클라이언트 요청에 대해 효율적인 DB 연결을 지원합니다.
    @Bean
    public BasicDataSource dataSource() {

        BasicDataSource basicDataSource = new BasicDataSource();  // DBCP2의 BasicDataSource 객체 생성
        // DBCP2는 Commons DBCP2 라이브러리를 기반으로 커넥션 풀링을 지원하는 구현체입니다.

        basicDataSource.setDriverClassName(driver);  // db.properties에서 가져온 드라이버 클래스 설정 (예: MySQL의 경우 com.mysql.cj.jdbc.Driver)
        // DB에 접속할 때 사용하는 JDBC 드라이버 클래스 이름을 설정합니다. 이 클래스는 DB와의 물리적인 연결을 관리하는 역할을 합니다.
        basicDataSource.setUrl(url);  // db.properties에서 가져온 DB URL 설정 (DB의 주소와 포트)
        // DB의 접속 주소를 설정합니다. 이 URL은 어떤 DB에 연결할지를 결정합니다. 예를 들어, MySQL의 경우 "jdbc:mysql://localhost:3306/mydb" 같은 형식을 사용합니다.
        basicDataSource.setUsername(username);  // db.properties에서 가져온 DB 사용자 이름 설정
        // DB에 접속할 때 사용할 사용자 이름을 설정합니다. 이는 DB의 권한 관리에 사용됩니다.
        basicDataSource.setPassword(password);  // db.properties에서 가져온 DB 비밀번호 설정
        // DB에 접속할 때 사용할 비밀번호를 설정합니다. 사용자 인증 과정에서 사용됩니다.

        return basicDataSource;  // 설정된 DataSource 객체 반환. 이 DataSource는 이후에 DB 연결에 사용됩니다.
        // 이 메서드는 Bean으로 등록된 DataSource 객체를 반환하여 Spring이 관리할 수 있도록 합니다.
    }

    // MyBatis의 SqlSessionFactory를 설정합니다. SqlSessionFactory는 MyBatis에서 SQL 실행과 트랜잭션을 관리하는 핵심 클래스입니다.
    // SqlSessionFactory는 MyBatis의 SQL 실행, 트랜잭션 관리, 그리고 매핑 설정을 처리합니다.
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();  // SqlSessionFactory를 생성하기 위한 팩토리 빈
        // SqlSessionFactoryBean은 Spring에서 MyBatis의 SqlSessionFactory를 생성하는 데 사용되는 FactoryBean입니다.
        sqlSessionFactoryBean.setDataSource(dataSource());  // 위에서 설정한 DataSource를 사용하여 DB 연결을 설정
        // SqlSessionFactory는 설정된 DataSource를 기반으로 SQL 세션을 관리합니다.
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));  // MyBatis 설정 파일 위치 설정
        // MyBatis의 환경 설정 파일(mybatis-config.xml)을 지정합니다. 이 파일에서 매퍼 설정, 캐시 설정, 트랜잭션 설정 등을 관리할 수 있습니다.
        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mapper/userMapper.xml"));  // MyBatis 매퍼 파일 설정. SQL 쿼리와 자바 객체를 매핑하는 데 사용됩니다.
        // userMapper.xml 파일은 실제 SQL 쿼리문과 매핑된 자바 메서드를 정의한 파일입니다. 이 파일에서 각 SQL 문이 어떤 메서드와 매핑되는지 관리합니다.

        return sqlSessionFactoryBean.getObject();  // 팩토리 빈에서 실제 SqlSessionFactory 객체를 반환
        // SqlSessionFactory 객체가 생성되면 이를 반환하여, MyBatis와 DB 간의 트랜잭션을 처리하는 데 사용됩니다.
    }

    // SqlSessionTemplate을 설정합니다. 이 클래스는 MyBatis의 SqlSession을 구현한 것으로, Spring과 MyBatis의 통합을 도와줍니다. 
    // SqlSessionTemplate은 스레드 세이프하고, SQL 실행 및 트랜잭션을 쉽게 관리할 수 있습니다.
    // SqlSessionTemplate은 SqlSession의 구현체로, MyBatis를 사용하여 DB 작업을 처리할 때 안전하게 사용됩니다.
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());  // SqlSessionFactory에서 SqlSessionTemplate 생성
        // SqlSessionTemplate은 Spring 환경에서 MyBatis와의 통합을 지원하며, 스레드 세이프하게 여러 스레드에서 동시에 사용할 수 있는 기능을 제공합니다.
        return sqlSessionTemplate;  // SqlSessionTemplate 객체 반환. 이 객체를 사용해 SQL 쿼리를 실행할 수 있습니다.
        // 반환된 SqlSessionTemplate을 사용하여 SQL 쿼리문을 실행하고, MyBatis의 다양한 기능을 사용할 수 있습니다.
    }

    // 트랜잭션 관리를 위한 DataSourceTransactionManager 설정입니다.
    // 이 매니저는 JDBC를 통한 트랜잭션을 관리하며, Spring의 @Transactional 어노테이션과 함께 사용됩니다.
    // DataSourceTransactionManager는 트랜잭션 관리자를 구현하는 클래스입니다. DB의 트랜잭션 경계를 설정하고 관리합니다.
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager(dataSource());  // DataSource 기반으로 트랜잭션 매니저 생성
        // DataSourceTransactionManager는 기본적으로 JDBC를 사용하는 DataSource와 함께 사용되며, Spring에서 제공하는 트랜잭션 관리 기능을 지원합니다.
        return dataSourceTransactionManager;  // 트랜잭션 매니저 객체 반환. 트랜잭션 관리에 사용됩니다.
        // 이 객체를 통해 Spring의 트랜잭션 관리 기능이 활성화되며, 트랜잭션 경계를 설정하여 롤백이나 커밋을 제어할 수 있습니다.
    }

}
