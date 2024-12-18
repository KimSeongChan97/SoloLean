package member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import member.bean.MemberPaging;
import member.dao.MemberRepository;
import member.entity.MemberEntity;

@Service
public class MemberServiceImpl implements MemberService {

    // MemberRepository와 MemberPaging을 주입받아 사용합니다. @Autowired는 의존성을 주입해주는 어노테이션입니다.
    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private MemberPaging memberPaging;

    @Override
    public String isExistId(String id) {
        // ID 존재 여부를 확인하는 메서드입니다.
        // 기존의 findById는 Integer 타입을 사용했지만, String id를 확인하기 위해 쿼리 메서드를 별도로 정의하여 사용합니다.
        // memberRepository에 정의된 findById 메서드를 통해 DB에서 회원 정보를 조회합니다.
        MemberEntity memberEntity = memberRepository.findById(id); // select * from membertbl where id=?
        System.out.println(memberEntity); // 조회한 회원 정보를 콘솔에 출력합니다.

        // memberEntity가 null인지 확인하여 null이면 "non_exist", null이 아니면 "exist" 문자열을 반환합니다.
        if(memberEntity == null)
            return "non_exist"; // 사용가능, 조회된 결과가 없으면 해당 ID는 사용 가능
        else
            return "exist"; // 사용 불가, 조회된 결과가 있으면 해당 ID는 중복
    };

    @Override
    public void write(MemberEntity memberEntity) {
        // 새 회원 정보를 저장하는 메서드입니다.
        // memberRepository의 save 메서드를 호출하여 memberEntity 객체를 DB에 저장합니다.
        memberRepository.save(memberEntity); // DB에 회원 정보 저장, insert 또는 update 쿼리가 실행됩니다.
    };

    @Override
    public Map<String, Object> getMemberList(Pageable pageable) {
        // 페이지 정보를 기반으로 회원 목록을 조회하는 메서드입니다.
        // Pageable은 페이지 번호, 크기, 정렬 등을 포함하는 객체로, 페이징 처리를 쉽게 도와줍니다.
        Page<MemberEntity> list = memberRepository.findAll(pageable); // findAll 메서드를 통해 페이징된 회원 리스트 조회
        
        // 총 회원 수를 가져옵니다.
        int totalA = memberRepository.findAll().size(); // 모든 회원의 수를 계산합니다.
        System.out.println("totalA = " + totalA); // 전체 회원 수를 콘솔에 출력하여 확인합니다.

        // 페이지 정보 세팅을 위한 설정입니다.
        memberPaging.setCurrentPage(pageable.getPageNumber() + 1); // 현재 페이지 번호 설정, 0부터 시작하므로 +1
        memberPaging.setPageBlock(3); // 한 화면에 보여줄 페이지 블록 수
        memberPaging.setPageSize(3); // 한 페이지에 보여줄 회원 수
        memberPaging.setTotalA(totalA); // 총 회원 수를 설정하여 페이징 계산에 활용
        memberPaging.makePaingHTML(); // HTML로 페이지 네이션을 만들어서 적용합니다.

        // 회원 리스트와 페이징 정보를 담을 Map 객체를 생성하고 반환합니다.
        Map<String, Object> map = new HashMap<>();
        map.put("list", list); // 회원 목록 데이터를 Map에 저장
        map.put("memberPaging", memberPaging); // 페이징 정보를 Map에 저장
        
        return map; // 리스트와 페이징 정보가 담긴 Map을 반환하여 컨트롤러에서 사용하도록 합니다.
    };

    @Override
    public Map<String, Object> getSearchList(String columnName, String value, Pageable pageable) {
        // 특정 조건으로 회원을 검색하여 결과를 반환하는 메서드입니다.
        // 검색할 컬럼명(columnName)과 검색 값(value)을 받아 검색 결과를 반환합니다.

        // 쿼리 메서드 사용 방식 주석 (아래 코드 부분은 주석 처리됨)
        // columnName이 "name"이면 findByNameContaining 메서드로 이름을 포함하는 결과를 찾습니다.
        // 그렇지 않으면 findByIdContaining 메서드로 ID를 포함하는 결과를 찾습니다.
        
        // @Query 어노테이션을 통해 정의된 사용자 지정 메서드 호출
        //if(columnName.equals("name")) {
        //    return memberRepository.getSearchName(value); // 이름 기준으로 검색 결과 반환
        //} else {
        //    return memberRepository.getSearchId(value); // ID 기준으로 검색 결과 반환
        //}
    	
    	Page<MemberEntity> list = columnName.equals("name")
                ? memberRepository.getSearchName(value, pageable)
                : memberRepository.getSearchId(value, pageable);

            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            return map;
    	
    };
}

/*
Optional
스프링 데이터 JPA를 사용하며 CrudRepository의 findById 메서드 리턴 타입인 Optional 클래스에 처음 접하게 되었다.
Optional은 Java 8에 추가된 새로운 API로 이전에 하던 '고통스러운 null 처리'를 '잘' 다룰 수 있게 도와주는 클래스라고 한다.

Optional 클래스란?
Optional이란 'null일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스이다.

쿼리 메소드
JPA에서 제공하는 CrudRepository, 또는 JpaRepository를 이용해서 기본적인 CRUD 기능을 수행했다.
일반적으로 JPA를 이용해서 목록 기능을 구현할 때는 JPQL(Java Persistence Query Language)을 이용하면 된다.
JPQL은 검색 대상이 테이블이 아닌 엔티티 라는 것만 제외하고는 기본 구조와 문법이 기존의 SQL과 유사하다.

스프링 JPA에서는 복잡한 JPQL을 대신해서 처리할 수 있는 쿼리 메소드라는 기능을 제공한다.
쿼리 메소드는 메소드의 이름으로 필요한 쿼리를 만들어주는 기능이다.

쿼리 메소드를 작성할 때 엔티티 이름은 생략할 수 있다.
현재 사용하는 Repository 인터페이스에서 선언된 타입 정보를 기준으로 자동 엔티티 이름이 적용된다.

쿼리 메소드의 리턴 타입은 Page<T>, Slice<T>, List<T> 이며 모두 Collection<T> 타입이다.
이 중에서 가장 많이 사용하는 것은 Page<T>, List<T>로서, 단순히 목록을 검색하려면 List<T>를 사용하고 페이징 처리를 하려면 Page<T>를 사용하면 된다.

*** @Query 어노테이션
일반적인 쿼리는 지금까지 학습한 스프링 데이터 JPA의 쿼리 메소드만으로도 충분하다. 
하지만 복잡한 쿼리를 사용하거나 연관관계에 기반한 조인 검색을 처리하기 위해서는 JPQL(Java Persistence Query Language)을 사용해야 한다. 
또는 성능상 어쩔 수 없이 특정 데이터베이스에 종속적인 네이티브 쿼리를 사용해야하는 경우도 있다.

JPQL은 일반적인 SQL과 유사한 문법을 가지고 있지만 검색 대상이 테이블이 아니라 영속성 컨텍스트에 등록된 엔티티이다.
따라서 FROM 절에 엔티티 이름과 컬럼 대신 엔티티가 가지고 있는 변수를 조회하기 때문에
SELECT나 WHERE 절에서 사용하는 변수 이름은 대소문자를 구분하여 정확하게 지정해야 한다.
*/
