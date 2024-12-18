package exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Emp {
    
    @Id // 기본 키(primary key)를 설정하는 애너테이션
    private int empno; // 사원 번호를 의미하며, 기본 키로 사용됨
    
    @Column(length = 14) // ename 컬럼의 최대 길이를 14로 설정
    private String ename; // 사원의 이름
    
    @Column(length = 30) // job 컬럼의 최대 길이를 30으로 설정
    private String job; // 사원의 직무
    
    private Integer mgr; // 매니저 사원 번호, null일 수 있으므로 Integer 타입 사용
    
    private java.sql.Date hiredate; // 입사 날짜
    
    private int sal; // 사원의 급여
    
    private Integer comm; // 커미션, null일 수 있으므로 Integer 타입 사용
    
    // 연관 매핑
    @ManyToOne(fetch = FetchType.EAGER) // 다대일 관계 설정 및 즉시 로딩 방식 사용
    //@ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 방식 설정
    @JoinColumn(name = "deptno", nullable = true) // 외래 키 컬럼 이름을 deptno로 지정
    private Dept deptno; // 부서 정보와 연결, Dept 엔티티 참조
    
    
}


/*
즉시 로딩 (Eager Loading)
연관된 엔티티를 즉시 로딩된다.
부모 엔티티가 로딩될 때 연관된 모든 데이터도 함께 로딩된다.
부모 엔티티를 로드할 때 연관된 데이터도 함께 DB에서 조회되어, 한 번의 쿼리로 모든 데이터를 가져온다.

지연 로딩 (Lazy Loading)
연관된 엔티티를 실제로 사용할 때까지 데이터를 로딩하지 않는다.
연관된 데이터는 해당 필드나 연관된 엔티티에 접근할 때, 즉 실제로 해당 데이터를 참조하거나 사용하려고 할 때 DB에서 로딩된다.

 */
