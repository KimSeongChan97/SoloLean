package exam.app;

import java.util.List; // List 인터페이스 import. JPQL 쿼리 결과를 담기 위해 사용.

import exam.entity.Person; // Person 엔티티 클래스 import. 이 클래스는 데이터베이스의 "person" 테이블과 매핑됨.
import jakarta.persistence.EntityManager; // JPA에서 엔티티를 관리하고 데이터베이스 작업을 수행하는 EntityManager 클래스 import.
import jakarta.persistence.EntityManagerFactory; // EntityManager 인스턴스를 생성하는 팩토리 클래스 import.
import jakarta.persistence.Persistence; // Persistence 클래스 import. 영속성 유닛을 관리하기 위해 사용.
import jakarta.persistence.TypedQuery; // 반환 타입이 명확한 JPQL 쿼리를 생성하기 위해 TypedQuery 클래스 import.

public class EntityTesAppt03 {
		
	public static void main(String[] args) {
		
		// EntityManagerFactory는 영속성 유닛을 관리하는 팩토리 객체로, EntityManager를 생성하기 위해 사용됨.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		// EntityManager는 엔티티를 관리하고 데이터베이스 작업을 수행하는 주요 인터페이스.
		EntityManager manager = factory.createEntityManager();
		
		// 트랜잭션
		// 트랜잭션은 데이터베이스의 일관성과 무결성을 보장하기 위해 사용되며, 데이터 삽입, 수정, 삭제 시 필수적임.
		manager.getTransaction().begin(); // 트랜잭션 시작

		// 새로운 Person 객체 생성 및 필드 값 설정
		Person p1 = new Person(); // 첫 번째 Person 객체 생성
		p1.setName("홍길동"); // name 필드에 "홍길동" 설정
		p1.setAge(25); // age 필드에 25 설정
		
		Person p2 = new Person(); // 두 번째 Person 객체 생성
		p2.setName("이제훈"); // name 필드에 "이제훈" 설정
		p2.setAge(40); // age 필드에 40 설정
		
		Person p3 = new Person(); // 세 번째 Person 객체 생성
		p3.setName("김태리"); // name 필드에 "김태리" 설정
		p3.setAge(32); // age 필드에 32 설정
		
		// persist() 메서드는 엔티티를 영속성 컨텍스트에 저장. 트랜잭션이 커밋될 때 데이터베이스에 반영됨.
		manager.persist(p1); // p1 객체를 영속성 컨텍스트에 저장
		manager.persist(p2); // p2 객체를 영속성 컨텍스트에 저장
		manager.persist(p3); // p3 객체를 영속성 컨텍스트에 저장
		
		// TypedQuery는 명확한 반환 타입을 가지는 JPQL 쿼리를 실행하기 위해 사용됨.
		TypedQuery<Person> q = manager.createQuery("SELECT p FROM Person p", Person.class);
		// "SELECT p FROM Person p"는 JPQL 쿼리로, Person 엔티티의 모든 데이터를 가져옴. 
		// p는 엔티티의 별칭으로, 쿼리 내에서 엔티티 필드에 접근할 수 있음.
		
		List<Person> list = q.getResultList(); // 쿼리 결과를 List에 저장. Person 객체의 리스트가 반환됨.
		
		// 조회된 데이터를 출력
		list.stream().forEach(System.out::println); // List의 각 Person 객체를 출력. forEach 메서드는 람다식으로 각 요소를 순회하며 출력함.
		//list.stream().forEach(e -> System.out.println(e)); // 위와 동일한 출력 방식. 람다식을 사용하여 리스트의 각 요소를 출력.
		
		manager.getTransaction().commit(); // 트랜잭션 커밋. 데이터베이스에 변경 내용 적용.
		manager.close(); 
		factory.close(); 
	}
}
