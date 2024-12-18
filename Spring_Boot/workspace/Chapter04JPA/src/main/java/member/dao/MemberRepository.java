package member.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import member.entity.MemberEntity;

//public interface MemberRepository extends JpaRepository<엔티티클래스, primary key> {}
// JpaRepository 인터페이스를 확장하여, 기본 CRUD 및 JPA 관련 기능을 사용할 수 있는 Repository입니다.
// JpaRepository의 제네릭 타입에 <엔티티 클래스, primary key의 타입>을 지정해야 합니다.
// 이 경우 MemberEntity를 사용하며, primary key 타입이 Integer입니다.

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    // ID를 기준으로 MemberEntity를 조회하는 메서드입니다.
    // Spring Data JPA의 메서드 이름 규칙에 따라, findById는 특정 ID와 일치하는 회원 정보를 가져옵니다.
    // 이 메서드는 문자열 ID 값을 기준으로 조회합니다.
    public MemberEntity findById(String id);

    // 쿼리 메서드
    // 이름 속성을 기준으로 검색하며, 일부 일치하는 값들도 검색이 가능하도록 'Containing'을 사용하여 LIKE 검색을 구현합니다.
    // 예를 들어, '홍'을 검색하면 '홍길동', '홍성민' 등 일부 일치하는 이름들도 포함하여 조회합니다.
    public List<MemberEntity> findByNameContaining(String value);
    
    // ID 속성을 기준으로 검색하는 메서드로, 일부 일치하는 ID도 검색할 수 있습니다.
    // 'Containing' 키워드는 LIKE 연산자를 사용하는 것과 동일하여, 일부 문자를 포함하는 값을 검색할 때 유용합니다.
    public List<MemberEntity> findByIdContaining(String value);
    
    // @Query 아노테이션
    // 복잡한 JPQL 쿼리를 직접 작성할 때 사용합니다.
    // 아래 메서드들은 특정 컬럼을 기준으로 조건을 걸어 검색할 때 사용됩니다. JPQL은 SQL과 유사하지만, 테이블이 아닌 엔티티를 대상으로 검색을 수행합니다.
    // 이 경우 MemberEntity 엔티티의 name 필드에서 조건에 맞는 결과를 가져옵니다.

    // @Query를 사용하여 이름(name) 속성에서 특정 값(value)을 포함하는 모든 엔티티를 검색하는 쿼리입니다.
    // :value는 @Param("value")와 매핑되며, 런타임 시 전달된 파라미터 값으로 대체됩니다.
    @Query("select entity from MemberEntity entity where entity.name like concat('%', :value, '%')")
    public Page<MemberEntity> getSearchName(@Param("value") String value, Pageable pageable);

    // @Query를 사용하여 ID(id) 속성에서 특정 값(value)을 포함하는 모든 엔티티를 검색하는 쿼리입니다.
    // 위의 메서드와 동일하게, :value는 @Param("value")로 전달된 파라미터 값으로 대체됩니다.
    @Query("select entity from MemberEntity entity where entity.id like concat('%', :value, '%')")
    public Page<MemberEntity> getSearchId(@Param("value") String value, Pageable pageable);
    
    
    
    
}
