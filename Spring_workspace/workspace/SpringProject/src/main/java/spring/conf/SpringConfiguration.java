package spring.conf;

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

@EnableTransactionManagement  // 이 어노테이션은 @Transactional을 사용하여 선언적 트랜잭션 관리를 활성화하는 역할을 합니다.
// @Transactional을 사용하면 개발자가 직접 트랜잭션 시작/종료/롤백 등을 처리할 필요 없이 선언적으로 트랜잭션을 관리할 수 있습니다.
@Configuration  // 이 어노테이션은 Spring 설정 클래스임을 나타냅니다. XML이 아닌 자바 클래스로 설정을 관리할 때 사용합니다.
// XML 기반의 설정 대신 자바 클래스로 스프링 빈을 설정하고 관리하기 위한 어노테이션입니다.
@PropertySource("classpath:spring/db.properties")  // 외부 properties 파일에서 DB 연결 정보를 불러오기 위해 사용됩니다.
// 외부 파일에서 DB 설정 정보(드라이버, URL, 사용자명, 비밀번호)를 불러와서 재사용할 수 있게 해줍니다. 유지보수가 용이합니다.
@MapperScan("user.dao") 
// 이 어노테이션은 MyBatis의 매퍼 인터페이스가 위치한 패키지를 지정합니다.
//Spring이 해당 패키지에서 매퍼 인터페이스를 스캔하고, MyBatis와 연결하여 SQL문을 실행할 수 있는 구현체를 자동으로 생성해줍니다.
//즉, user.dao 패키지 안에 있는 @Mapper로 선언된 인터페이스들을 MyBatis가 자동으로 인식하고 사용할 수 있게 합니다.
//각 매퍼 인터페이스는 SQL 쿼리와 매핑되어 DB와 상호작용할 수 있습니다.
//이를 통해 개발자는 매퍼 인터페이스를 통해 직접 SQL 쿼리를 호출하지 않고도 데이터베이스 작업을 수행할 수 있습니다.
public class SpringConfiguration {
		
    // @Value 어노테이션은 properties 파일에서 값을 읽어올 때 사용됩니다. db.properties 파일에서 각각의 값(driver, url, username, password)을 가져옵니다.
    // @Value는 설정 파일의 키 값을 어노테이션의 필드에 주입해주는 역할을 합니다.
    private @Value("${jdbc.driver}") String driver;  // jdbc.driver 속성을 db.properties 파일에서 가져옴
    private @Value("${jdbc.url}") String url;  // jdbc.url 속성을 db.properties 파일에서 가져옴
    private @Value("${jdbc.username}") String username;  // jdbc.username 속성을 db.properties 파일에서 가져옴
    private @Value("${jdbc.password}") String password;  // jdbc.password 속성을 db.properties 파일에서 가져옴
    
    @Autowired
    private ApplicationContext context; 
    // ApplicationContext는 Spring 프레임워크에서 모든 빈을 관리하고 제공하는 핵심 인터페이스입니다.
    // context는 Spring 설정 파일 또는 어노테이션을 통해 정의된 빈(bean) 객체를 관리하고 필요한 곳에 주입해주는 역할을 합니다.

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

        // 추가 설명: 커넥션 풀링은 동일한 DB에 대한 여러 연결을 미리 열어두고 필요한 때 사용하고, 사용이 끝나면 풀로 반환하여 재사용하는 방식으로
        // 애플리케이션의 성능을 향상시킵니다. 특히 DB와의 연결은 비용이 많이 드는 작업이기 때문에 커넥션 풀링은 매우 유용합니다.

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
        //sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mapper/userMapper.xml"));  // 1개의 매퍼파일, MyBatis 매퍼 파일 설정. SQL 쿼리와 자바 객체를 매핑하는 데 사용됩니다.
        // userMapper.xml 파일은 실제 SQL 쿼리문과 매핑된 자바 메서드를 정의한 파일입니다. 이 파일에서 각 SQL 문이 어떤 메서드와 매핑되는지 관리합니다.
        
        // 2개의 매퍼파일 연결
//        sqlSessionFactoryBean.setMapperLocations(
//        						new ClassPathResource("mapper/userMapper.xml"),
//        						new ClassPathResource("mapper/userUploadMapper.xml"));
        // 위의 코드에서는 두 개의 MyBatis 매퍼 파일(userMapper.xml, userUploadMapper.xml)을 설정하고 있습니다.
        // MyBatis에서 매퍼 파일은 SQL 쿼리문과 자바 객체 간의 매핑을 정의하는 XML 파일입니다.
        // 각 매퍼 파일은 특정 DAO(데이터 접근 객체) 또는 서비스와 연동되어, 해당 매퍼 파일에 정의된 SQL을 통해 데이터베이스 작업을 처리합니다.
        // setMapperLocations 메서드를 통해 각각의 XML 파일 경로를 ClassPathResource로 지정하여, MyBatis가 이 파일들을 로드하고 처리할 수 있도록 설정합니다.
        // 예를 들어, userMapper.xml은 User 관련된 DB 작업을 정의하고, userUploadMapper.xml은 파일 업로드 관련 작업을 처리할 수 있습니다.
        
        // 다수의 매퍼파일 연결
        sqlSessionFactoryBean.setMapperLocations(
        						context.getResources("classpath:mapper/*Mapper.xml"));
        // 위의 코드에서는 다수의 MyBatis 매퍼 파일을 한꺼번에 설정하고 있습니다.
        // context.getResources("classpath:mapper/*Mapper.xml")은 Spring의 ApplicationContext를 사용하여
        // classpath 내의 "mapper" 디렉토리에서 "*Mapper.xml"로 끝나는 모든 매퍼 파일을 로드합니다.
        // 즉, "mapper" 폴더 내에 있는 모든 매퍼 파일이 자동으로 등록됩니다.
        // 이는 매퍼 파일이 여러 개일 때, 각각의 파일을 수동으로 지정할 필요 없이 일괄로 설정할 수 있게 해주어 개발의 편의성을 높입니다.
        // 예를 들어, userMapper.xml, orderMapper.xml, productMapper.xml 등 다양한 매퍼 파일을 한 번에 로드할 수 있습니다.
        // Spring이 제공하는 "classpath:" 접두어를 사용하여 클래스 경로(classpath)에 있는 리소스를 참조하며, "*.xml" 형식을 사용해 와일드카드로 여러 파일을 지정할 수 있습니다.        
        
        
        //sqlSessionFactoryBean.setTypeAliasesPackage("user.bean");
        sqlSessionFactoryBean.setTypeAliasesPackage("*.bean");
        // user.bean 안에 있는 패키지 모두 알리아스로 지정
        // user.bean.UserDTO -> userDTO
	     // SQL 세션 팩토리 빈 객체에 TypeAliasPackage 설정을 한다.
	     // "setTypeAliasesPackage" 메소드는 MyBatis에서 사용되는 메서드로, 
	     // 특정 패키지 안에 있는 클래스들을 MyBatis의 타입 별칭(Type Alias)으로 등록할 수 있게 해준다.
	     // "Type Alias"는 MyBatis에서 사용되는 개념으로, 클래스의 전체 경로를 줄여서 사용할 수 있는 짧은 이름을 제공해준다.
	     // 여기서는 "*.bean" 이라는 패키지명을 전달하고 있는데, 
	     // 이 패턴은 'bean' 이라는 이름을 포함한 패키지 안의 모든 클래스에 대해 별칭을 적용하려는 의도로 보인다.
	     // 주의: "*.bean" 패턴은 실제로 제대로 동작하지 않을 수 있음.
	     // 정확한 패키지 경로를 명시하는 것이 일반적으로 권장된다. 예를 들어 "com.example.bean" 와 같이 사용할 수 있다.
        
        
        
        
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
