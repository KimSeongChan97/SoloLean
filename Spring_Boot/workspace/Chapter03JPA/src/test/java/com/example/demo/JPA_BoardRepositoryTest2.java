package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @AutoConfigureTestDatabase 어노테이션은 테스트에서 사용할 데이터베이스를 설정하는 역할을 합니다.
// replace 속성을 AutoConfigureTestDatabase.Replace.NONE으로 설정하여 Spring Boot의 기본 내장 데이터베이스(H2)를 사용하지 않고,
// 실제 외부 데이터베이스(MySQL 등)에 연결하여 테스트를 수행하도록 합니다.
// 이 설정으로 인한 이점은 실제 서비스 환경과 동일한 DB 환경에서 테스트할 수 있다는 것입니다.

@DataJpaTest
// @DataJpaTest는 JPA 관련 컴포넌트만 활성화하여 테스트할 수 있는 어노테이션입니다.
// 이 어노테이션을 사용하면 엔티티와 관련된 CRUD 작업, 트랜잭션 처리를 포함한 JPA 기능 테스트가 가능하며,
// 기본적으로 내장 데이터베이스를 사용하나, AutoConfigureTestDatabase.Replace.NONE 설정을 통해 외부 DB와 연동이 가능합니다.
// 이는 JPA 레포지토리의 기능을 빠르게 테스트할 때 유용합니다.

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @TestMethodOrder는 테스트 메서드의 실행 순서를 지정하는 어노테이션입니다.
// MethodOrderer.OrderAnnotation.class를 통해 @Order 어노테이션의 값에 따라 테스트가 실행됩니다.
// 이를 통해 특정 테스트가 다른 테스트보다 먼저 실행되도록 순서를 제어할 수 있습니다.
// 테스트 순서 지정은 의존 관계가 있는 테스트가 있을 때 유용하게 사용됩니다.

public class JPA_BoardRepositoryTest2 {

    @Autowired
    private BoardDAO boardDAO;
    // @Autowired는 스프링이 BoardDAO 빈을 자동으로 주입해줍니다.
    // 이로써 boardDAO 객체를 통해 데이터베이스에 접근하여 CRUD(Create, Read, Update, Delete) 작업을 수행할 수 있습니다.
    // BoardDAO는 JPA Repository나 CrudRepository 인터페이스를 상속하여 데이터 액세스 계층의 기능을 제공합니다.
    // @Autowired 어노테이션을 통해 Spring이 이 의존성을 자동으로 관리하므로 수동으로 객체를 생성할 필요가 없습니다.

    @BeforeEach
    public void solid() {
        System.out.println("-*=".repeat(50));
        // @BeforeEach는 각 테스트 메서드가 실행되기 전에 항상 실행되는 메서드를 정의할 때 사용합니다.
        // 여기서는 각 테스트 실행 전에 구분선(패턴 문자열)을 출력하여, 테스트 시작 부분을 시각적으로 표시하는 역할을 합니다.
        // 이를 통해 각 테스트의 시작과 종료 지점을 쉽게 구분할 수 있으며, 테스트 로그가 시각적으로 정리됩니다.
    };

    @AfterEach
    public void solid2() {
        System.out.println("=*-".repeat(50));
        // @AfterEach는 각 테스트 메서드가 실행된 후에 항상 실행되는 메서드를 정의할 때 사용합니다.
        // 이 메서드는 테스트가 종료된 후 구분선 패턴을 출력하여 테스트 종료 지점을 시각적으로 표시합니다.
        // 또한 테스트가 여러 개 실행될 때 구분이 잘 되도록 해주어 디버깅과 로그 분석이 용이합니다.
    };

    /*
     * @AfterEach public void cleanup() { boardDAO.deleteAll();
     * System.out.println("All records deleted after each test."); }
     */
    // 위의 주석 처리된 cleanup() 메서드는 각 테스트 후 데이터베이스의 모든 레코드를 삭제하기 위한 메서드입니다.
    // 이 메서드를 활성화하면 테스트 실행 후 boardDAO.deleteAll()을 통해 모든 데이터를 삭제하여, 데이터 중복으로 인한 충돌을 방지할 수 있습니다.
    // @AfterEach를 사용하기 때문에 각 테스트 메서드 실행 후에 자동으로 실행됩니다.
    // 이 메서드는 테스트 간 데이터 간섭을 방지하여 테스트의 독립성을 높입니다.

    @Test
    @Order(1) // 실행순서를 정한다, 숫자가 작을수록 먼저 실행한다.
    @Rollback(false) // default 가 true 값 이다, DML 문 수행한 후에 rollback 을 원하지 않다면 false 로 막는다.
    public void insert() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId("banana");
        boardEntity.setName("바나나");
        boardEntity.setSubject("노란 바나나");
        boardEntity.setContent("예전에는 바나가가 정말 정말 비쌌다.");
        // 새로운 BoardEntity 객체를 생성하고 필요한 필드들을 설정합니다.
        // setId("banana")를 통해 고유한 ID 값으로 설정하고, setName, setSubject, setContent 메서드로 각각의 필드를 초기화합니다.
        // 각 필드에 의미 있는 데이터를 설정하여 테스트의 신뢰성을 높이며,
        // 데이터의 식별이 쉽도록 식별자(ID)를 설정하는 것이 중요합니다.

        boardDAO.save(boardEntity); // 레코드가 있으면 수정(update), 없으면 입력(insert)로 수행한다.
        // boardDAO.save(boardEntity)는 엔티티를 데이터베이스에 저장하는 메서드입니다.
        // 만약 데이터베이스에 동일한 ID를 가진 레코드가 이미 존재하면, 해당 레코드를 업데이트하고,
        // 그렇지 않으면 새로운 레코드를 추가(insert)합니다.
        // 이 방식은 영속성 컨텍스트에 의해 관리되며 JPA가 변경사항을 감지하여 자동으로 적용됩니다.
    };

    @Test
    @Order(2)
    @Rollback(false)
    public void insert2() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId("strawberry");
        boardEntity.setName("딸기");
        boardEntity.setSubject("탐스러운 딸기");
        boardEntity.setContent("달달허이");

        boardDAO.save(boardEntity); 
        // 위와 마찬가지로 새 엔티티를 설정하고 저장하여 데이터베이스에 반영합니다.
        // 각 필드는 실제 서비스 시나리오에 근접한 데이터를 사용하여 테스트 결과의 신뢰성을 높입니다.
    };

    @Test
    public void list() {
        List<BoardEntity> list = boardDAO.findAll();
        // boardDAO.findAll() 메서드를 호출하여 BoardEntity 객체 리스트를 가져옵니다.
        // findAll() 메서드는 JPA Repository에서 제공하는 기본 메서드 중 하나로,
        // 엔티티 테이블의 모든 데이터를 조회하여 List 형태로 반환합니다.
        // 이를 통해 현재 데이터베이스에 존재하는 모든 BoardEntity 객체를 쉽게 조회할 수 있습니다.

        list.stream().forEach(System.out :: println);
        // 가져온 리스트의 각 요소를 스트림으로 변환한 뒤, 각 요소를 System.out.println 으로 출력합니다.
        // 이 부분은 데이터베이스에서 조회된 각 BoardEntity 객체의 정보를 콘솔에 출력하기 위한 것입니다.
        // 테스트 실행 중 데이터베이스에 저장된 데이터를 확인할 수 있도록 출력합니다.
        // 스트림을 사용하여 코드가 간결해지며, 각각의 엔티티 정보를 출력함으로써 저장된 데이터의 유효성을 확인할 수 있습니다.
    };

    // ---------------------------------------------------------------------------------    
    // 쿼리 메서드
    
    @Test
    public void byId() {
        BoardEntity boardEntity = boardDAO.findById(8).get(); // Column의 id 가 아닌 BoardEntity 파일의 @Id 를 설정한 값을 검색해옴( seq )
        System.out.println(boardEntity);
    };
    // @Id 어노테이션이 이 있는 컬럼을 조회하는 기존에 존재하는 메서드
    // findById 메서드는 기본 JPA 메서드로, 기본 키를 통해 특정 엔티티를 조회합니다.
    // 여기서 사용한 .get()은 Optional 객체에서 실제 BoardEntity 객체를 추출하는 메서드입니다.
    // 만약 데이터가 없으면 NoSuchElementException을 던질 수 있으므로 주의가 필요합니다.

    @Test
    public void bySeq() {
        BoardEntity boardEntity = boardDAO.findBySeq(8);
        System.out.println(boardEntity);
    };
    // 사용자가 만든 쿼리 메서드
    // seq 값을 찾는 쿼리메서드
    // findBySeq는 JPA 쿼리 메서드 규칙에 따라 seq 값이 8인 레코드를 반환합니다.
    // JPA는 메서드 이름에서 조건을 파악하여 SQL 쿼리를 자동 생성하므로 사용자 쿼리 메서드를 편리하게 만들 수 있습니다.

    @Test
    public void bySeqBetween() {
        List<BoardEntity> list = boardDAO.findBySeqBetween(2, 5);
        list.stream().forEach(System.out :: println);
    };
    // 사용자가 만든 쿼리 메서드
    // seq 의 값이 현재 2 보다 크고, 5보다 작은 값을 조회하는 쿼리메서드 ( Between )
    // findBySeqBetween은 JPA에서 특정 컬럼의 범위를 조회할 수 있는 기능으로, start와 end 값 사이에 있는 데이터를 반환합니다.
    // Between 연산을 사용하여 범위 조회를 구현하므로 범위 내 데이터를 쉽게 검색할 수 있습니다.

    @Test
    public void byLogtimeNull() {
        List<BoardEntity> list = boardDAO.findByLogtimeNull(); 
        list.stream().forEach(System.out :: println);
    };
    // 사용자가 만든 쿼리 메서드
    // Logtime 이 null 인 메서드를 찾는 쿼리메서드
    // findByLogtimeNull은 logtime 컬럼이 null인 모든 엔티티를 조회하는 메서드입니다.
    // 이 메서드는 NULL 상태를 조건으로 사용하여 특정 필드가 설정되지 않은 엔티티를 찾는데 유용합니다.

    @Test
    public void byIdContain() {
        String key = "o";
        List<BoardEntity> list = boardDAO.findByIdContaining(key);
        list.stream().forEach(System.out :: println);
    };
    // 사용자가 만든 쿼리 메서드
    // id 값에 'o' 가 들어가는 모든 레코드를 조회하는 쿼리메서드 (Containing)
    // findByIdContaining은 특정 문자열을 포함하는 엔티티를 검색하는 데 유용합니다.
    // 'Containing' 키워드는 SQL의 LIKE 구문과 유사하게 작동하여 부분 일치를 지원합니다.

    @Test
    public void byLogtimeAfter() {
        
        // BoardEntity 에서 private java.sql.Date logtime; 으로 설정 하였을 때
        // List<BoardEntity> list = boardDAO.findByLogtimeAfter(java.sql.Date.valueOf("2024-11-12"));
            
        // BoardEntity 에서 private LocalDateTime logtime = LocalDateTime.now(); 으로 설정 하였을 때
        List<BoardEntity> list = boardDAO.findByLogtimeAfter(LocalDateTime.of(2024, 11, 12, 00, 00, 00));
        list.stream().forEach(System.out :: println);
    };
    // 사용자가 만든 쿼리 메서드
    // Logtime 을 After 에 있는걸 조회하는 쿼리메서드
    // findByLogtimeAfter는 특정 날짜 이후의 엔티티만 검색하는 메서드입니다.
    // LocalDateTime이나 java.sql.Date를 사용하여 시간 기준으로 조회할 수 있습니다.
}
