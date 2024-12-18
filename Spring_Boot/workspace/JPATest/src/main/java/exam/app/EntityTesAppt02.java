package exam.app;

import java.util.List; // List 인터페이스를 사용하기 위해 java.util 패키지에서 import.

import exam.entity.EntityTest01; // EntityTest01 클래스 import. 이 클래스는 JPA 엔티티로 데이터베이스와 매핑됨.
import jakarta.persistence.EntityManager; // JPA의 EntityManager 클래스 import. 데이터베이스 작업의 핵심 인터페이스임.
import jakarta.persistence.EntityManagerFactory; // EntityManager 인스턴스를 생성하기 위한 팩토리 클래스 import.
import jakarta.persistence.Persistence; // 영속성 유닛을 관리하기 위한 Persistence 클래스 import.
import jakarta.persistence.TypedQuery; // TypedQuery 클래스 import. 반환 타입이 명확한 JPQL 쿼리를 작성하기 위해 사용됨.

public class EntityTesAppt02 {
	
	public static void main(String[] args) {
        // EntityManagerFactory는 영속성 유닛을 생성하고 관리하기 위한 팩토리 객체.
        // "entitytest"는 persistence.xml 파일에 정의된 영속성 유닛의 이름임.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        
        // EntityManager는 엔티티의 CRUD 작업을 수행하며, 영속성 컨텍스트를 통해 엔티티의 상태를 관리.
		EntityManager manager = factory.createEntityManager();
        
        // JPQL(JPA Query Language) 쿼리를 작성하여 EntityTest01 엔티티를 대상으로 데이터 조회.
        TypedQuery<EntityTest01> tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
        // t 라는 이름의 EntityTest01 테이블로 설정하고 t 의 값을 가져오고, EntityTest01을 class 로 지정한다
        // JPQL에서 "select t from EntityTest01 t"는 데이터베이스의 "entitytesttlb" 테이블에 매핑된 EntityTest01 엔티티의 모든 행을 가져옴.
        // t 는 엔티티의 별칭이며, 쿼리 내에서 이 별칭을 통해 엔티티 필드에 접근 가능.
        
        // TypedQuery의 getResultList() 메서드는 쿼리 실행 후 결과를 List 형태로 반환함.
        List<EntityTest01> list = tq.getResultList();
        
		//for(EntityTest01 et : list) {
		// System.out.println(et);
		//}
        // 위의 주석 처리된 for-each 루프는 각 엔티티를 콘솔에 출력하기 위해 사용됨.
        // 주석으로 유지된 코드는 간단한 엔티티 출력 예시로, List의 각 요소를 순회하며 출력하는 방식임.
        
        // Stream API의 forEach 메서드를 사용하여 각 엔티티 객체를 출력.
        list.stream().forEach(e -> System.out.println(e));
        // stream().forEach는 람다식을 이용해 List 내의 각 요소를 순회하며 지정된 작업을 수행.
        // 여기서는 각 EntityTest01 객체를 System.out.println을 통해 출력함.

        manager.close();
        factory.close();
        
	}
	
}
