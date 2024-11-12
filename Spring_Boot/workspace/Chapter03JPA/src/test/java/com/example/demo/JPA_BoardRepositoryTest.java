package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

//@DataJpaTest 를 사용하면 자동으로 EmbededDatabase-H2를 사용하게 된다.
//MySQL 과 같이 외부의 DB 를 연결하려는 경우엔 이 어노테이션을 설정한다.
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 내장 DB 가 H2를 수행하지 않는다.
// @AutoConfigureTestDatabase 어노테이션은 테스트에 사용할 데이터베이스를 설정하는 역할을 합니다.
// replace 속성을 AutoConfigureTestDatabase.Replace.NONE 으로 설정하여 기본적으로 사용하는 H2 내장 데이터베이스를 무시하고, 
// 실제 외부 데이터베이스(MySQL 등)와 연결하도록 지정합니다.
@DataJpaTest // 외부 DB 연결
// @DataJpaTest 는 JPA 관련 컴포넌트만 테스트할 수 있는 어노테이션입니다.
// 이 어노테이션을 사용하면 JPA와 관련된 설정만 활성화되고, 데이터베이스와의 상호작용을 테스트할 수 있습니다.
// 주의할 점은 기본적으로 내장 데이터베이스(H2)를 사용하는데, 현재 설정에서는 외부 데이터베이스(MySQL)를 사용하도록 설정되어 있습니다.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @TestMethodOrder 는 테스트 메서드의 실행 순서를 정의하는 어노테이션입니다.
// 여기서는 MethodOrderer.OrderAnnotation.class 를 사용하여 @Order 어노테이션이 적용된 순서대로 테스트 메서드를 실행하도록 설정했습니다.
public class JPA_BoardRepositoryTest {
    
    @Autowired
    private BoardDAO boardDAO;
    // @Autowired 를 통해 스프링이 BoardDAO 빈을 자동으로 주입(injection)합니다.
    // 이로써 boardDAO 객체를 통해 데이터베이스에 접근하여 CRUD (Create, Read, Update, Delete) 작업을 수행할 수 있습니다.
    // BoardDAO는 JPA Repository 혹은 CRUD Repository 인터페이스를 상속하여 데이터 액세스 계층의 기능을 제공합니다.
    
    @BeforeEach
    public void solid() {
        // @BeforeEach 는 각 테스트 메서드가 실행되기 전에 항상 호출되는 메서드를 정의할 때 사용합니다.
        // 여기서는 테스트 실행 전 구분선(특정 문자열)을 콘솔에 출력하여, 각 테스트의 시작을 시각적으로 구분하는 역할을 합니다.
    	System.out.println("-*=".repeat(50));
        // "*=*=*=...*" 패턴을 50번 반복하여 시각적인 구분자를 생성합니다.
    };
    
    @AfterEach
    public void solid2() {
        // @AfterEach 는 각 테스트 메서드가 실행된 후에 항상 호출되는 메서드를 정의할 때 사용합니다.
        // 이 메서드도 구분선을 출력하여 테스트 종료를 시각적으로 표시하는 역할을 합니다.
    	System.out.println("=*-".repeat(50));
        // "=*-*-*-...*=" 패턴을 50번 반복하여 시각적인 구분자를 생성합니다.
    }; // spring 의 aop
    // 참고로, 이러한 방법은 Spring AOP(관점 지향 프로그래밍)의 개념으로도 구현할 수 있습니다. AOP는 특정 로직을 각 메서드 실행 전후에 추가할 수 있게 해주는 기법입니다.
    
    @Test
    public void list1() {
        // list1 메서드는 데이터베이스에 있는 모든 게시판(BoardEntity) 데이터를 조회하는 테스트 메서드입니다.
        List<BoardEntity> list = boardDAO.findAll();
        // boardDAO의 findAll 메서드를 호출하여 BoardEntity 객체의 리스트를 가져옵니다.
        // findAll() 메서드는 JPA Repository에서 제공하는 기본 메서드 중 하나로, 해당 엔티티 테이블의 모든 데이터를 조회합니다.
        list.stream().forEach(System.out :: println);
        // 가져온 list의 각 요소를 스트림으로 변환한 뒤, 각 요소를 System.out.println 으로 출력합니다.
        // 이 부분은 리스트에 저장된 각 BoardEntity 객체의 정보를 콘솔에 출력하기 위해 사용됩니다.
        // 콘솔 출력은 테스트 목적으로 데이터베이스의 데이터를 확인하는 용도로 사용됩니다.
    };
    
    @Test
    public void list2() {
        // list2 메서드는 BoardEntity 데이터를 name 컬럼을 기준으로 오름차순 정렬하여 조회하는 테스트입니다.
        List<BoardEntity> list = boardDAO.findAll(Sort.by("name").ascending());
        // findAll 메서드에 Sort.by("name").ascending() 옵션을 전달하여, name 컬럼을 기준으로 오름차순으로 정렬된 데이터를 가져옵니다.
        list.stream().forEach(System.out :: println);
        // 결과를 스트림으로 변환하여 각 엔티티를 출력합니다.
    }; // 오름차순
    
    @Test
    public void list3() {
        // list3 메서드는 BoardEntity 데이터를 name 컬럼을 기준으로 내림차순 정렬하여 조회하는 테스트입니다.
        List<BoardEntity> list = boardDAO.findAll(Sort.by("name").descending());
        // findAll 메서드에 Sort.by("name").descending() 옵션을 전달하여, name 컬럼을 기준으로 내림차순으로 정렬된 데이터를 가져옵니다.
        list.stream().forEach(System.out :: println);
        // 결과를 스트림으로 변환하여 각 엔티티를 출력합니다.
    }; // 내림차순
    
    @Test
    public void list4() {
        // list4 메서드는 BoardEntity 데이터를 페이지네이션하여 조회하는 테스트입니다.
        Page<BoardEntity> list = boardDAO.findAll(PageRequest.of(0, 3)); // pageNumber, pageSize
        // findAll 메서드에 PageRequest.of(0, 3)을 전달하여 첫 번째 페이지(0번 페이지)의 3개의 데이터만 가져옵니다.
        // PageRequest.of(page, size) 메서드는 지정된 페이지(page)와 데이터 개수(size)를 기준으로 데이터를 페이징 처리합니다.
        list.stream().forEach(System.out :: println);
        // 결과 페이지 내의 각 엔티티를 출력하여, 페이징된 데이터를 확인할 수 있습니다.
    }; 
    
    @Test
    public void list5() {
        // list5 메서드는 두 번째 페이지의 데이터를 페이징하여 조회하는 테스트입니다.
        Page<BoardEntity> list = boardDAO.findAll(PageRequest.of(1, 3)); // pageNumber, pageSize
        // PageRequest.of(1, 3)을 전달하여 두 번째 페이지(1번 페이지)의 3개의 데이터만 가져옵니다.
        // 페이지 번호는 0부터 시작하므로, 1번 페이지는 실제로 두 번째 페이지를 의미합니다.
        list.stream().forEach(System.out :: println);
        // 페이징 처리된 두 번째 페이지의 각 엔티티를 출력하여 확인합니다.
    }; 
    
    @Test
    public void list6() {
        // list6 메서드는 BoardEntity 데이터를 페이지네이션과 정렬을 함께 적용하여 조회하는 테스트입니다.
        Page<BoardEntity> list = boardDAO.findAll(PageRequest.of(0, 3, Sort.by("name")));
        // PageRequest.of(0, 3, Sort.by("name"))을 사용하여 첫 번째 페이지의 3개의 데이터를 가져오되,
        // name 컬럼을 기준으로 정렬하여 가져옵니다. 정렬과 페이징이 동시에 적용됩니다.
        list.stream().forEach(System.out :: println);
        // 정렬 및 페이징이 적용된 각 엔티티를 출력하여 결과를 확인합니다.
    }; 
    
};
