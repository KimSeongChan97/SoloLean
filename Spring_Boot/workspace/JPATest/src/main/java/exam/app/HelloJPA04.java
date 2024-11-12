package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA04 {
        
    public static void main(String[] args) throws Exception {
        
        // EntityManagerFactory 생성
        // EntityManagerFactory는 EntityManager 인스턴스를 생성하는데 사용됩니다.
        // "entitytest"라는 이름의 persistence unit을 사용하여 EntityManagerFactory를 생성합니다.
        // persistence.xml 파일에 정의된 설정을 사용하여 데이터베이스 연결을 설정합니다.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        
        // EntityManager 생성
        // EntityManager는 데이터베이스와의 상호작용을 관리하는 주요 인터페이스입니다.
        // EntityManager를 통해 데이터베이스 트랜잭션을 처리하고 쿼리를 실행합니다.
        EntityManager manager = factory.createEntityManager();
        
        // Fetch Join을 사용한 JPQL 쿼리문 생성
        // fetchJoinJpql 문자열에 JPQL 쿼리를 정의합니다. 이 쿼리는 Emp 엔티티와 관련된 부서(deptno) 엔티티,
        // 그리고 부서의 지역 코드(loc_code)를 함께 로드하는 Fetch Join을 사용합니다.
        // "select distinct t"는 중복된 Emp 엔티티가 반환되지 않도록 distinct 키워드를 사용합니다.
        // "left join fetch"는 Emp 엔티티에 대해 deptno 및 loc_code 연관 데이터를 한 번에 가져오는 방식입니다.
        // Fetch Join을 사용하면 지연 로딩(Lazy Loading) 문제를 피하고 필요한 데이터들을 한 번에 가져올 수 있습니다.
        // Emp와 연관된 부서 정보와 부서의 지역 코드까지 한 번에 가져옴으로써 N+1 문제를 방지할 수 있습니다.
        String fetchJoinJpql = "select distinct t " +
                               "from Emp t left join fetch t.deptno " + 
                               "left join fetch t.deptno.loc_code";
        
        // JPQL을 통해 생성한 fetchJoinJpql 쿼리를 실행하기 위해 Query 객체 생성
        // manager.createQuery(fetchJoinJpql, Emp.class)를 통해 JPQL 쿼리를 실행할 Query 객체를 생성합니다.
        // Query 객체를 통해 JPQL 쿼리를 데이터베이스에 전달합니다.
        // Query 객체는 SQL의 PreparedStatement와 유사한 역할을 합니다. JPQL 쿼리를 실행하기 위한 준비 단계를 거칩니다.
        Query query = manager.createQuery(fetchJoinJpql, Emp.class); // JPQL, Emp 은 Entity Class 이다.
        
        // getResultList() 메서드를 통해 쿼리 실행 결과를 List 타입으로 반환받습니다.
        // Emp 엔티티 리스트가 반환되며, 여기에는 Emp 엔티티와 관련된 deptno 및 loc_code 정보가 포함됩니다.
        // 데이터베이스에서 조회된 결과를 Java 컬렉션(List) 형태로 받을 수 있으며, 
        // 여기에는 Fetch Join을 통해 미리 로드된 연관 엔티티의 정보도 포함되어 있습니다.
        List<Emp> list = query.getResultList();       
        System.out.println(); 
        
        // 조회된 Emp 엔티티 리스트를 반복하며 각 엔티티의 정보 출력
        // for-each문을 사용하여 리스트에 포함된 각 Emp 객체의 정보를 출력합니다.
        // emp.toString() 메서드를 통해 엔티티의 속성 값을 문자열로 반환하며, 콘솔에 출력합니다.
        for(Emp emp : list) {
            // 각 emp 객체의 toString() 메서드 호출을 통해 객체 정보를 콘솔에 출력합니다.
            // Thread.sleep(100)은 각 출력 사이에 0.1초의 지연을 추가하여 출력 내용을 천천히 볼 수 있게 합니다.
            System.out.println(emp);
            Thread.sleep(100);
        } // for

        // 총 데이터 개수 출력
        // list.size() 메서드를 통해 조회된 데이터의 총 개수를 구하여 콘솔에 출력합니다.
        // 이를 통해 전체 조회된 Emp 엔티티 수를 알 수 있습니다.
        System.out.println("데이터 총 갯수 = " + list.size());

        // EntityManager 종료
        // manager.close()를 호출하여 EntityManager를 종료합니다. 이는 리소스를 해제하는 중요한 과정입니다.
        // 데이터베이스와의 연결을 종료하고, 사용된 메모리를 해제하여 성능을 최적화합니다.
        manager.close();
        
        // EntityManagerFactory 종료
        // factory.close()를 호출하여 EntityManagerFactory를 종료합니다. 이는 애플리케이션 전체가 종료될 때 호출해야 합니다.
        // 여러 EntityManager 인스턴스를 생성할 수 있는 팩토리를 종료하여 모든 연결과 설정을 정리합니다.
        factory.close();
    }
}

/*

fetch join
- 연관된 엔티티들을 한번의 쿼리로 모두 처리한다.
- 여러개의 연관된 엔티티들을 조인하여 한번의 쿼리로 모든 데이터들을 가져온다.

fetch join의 장점
- Lazy Loading으로 인해 발생하는 다수의 쿼리 호출을 방지하여 성능을 개선합니다.
- 필요한 데이터들을 한 번에 로드하므로 코드 가독성이 좋아지고 트랜잭션 관리가 용이해집니다.

*/