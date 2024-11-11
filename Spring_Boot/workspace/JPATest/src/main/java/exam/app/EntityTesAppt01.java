package exam.app;

import java.time.LocalDateTime; // Java에서 현재 시간을 다루기 위해 LocalDateTime 클래스 import

import exam.entity.EntityTest01; // 엔티티 클래스 import
import jakarta.persistence.EntityManager; // JPA에서 엔티티 매니저를 사용하기 위한 import
import jakarta.persistence.EntityManagerFactory; // 엔티티 매니저 팩토리 import
import jakarta.persistence.Persistence; // 영속성 유닛 관리를 위한 Persistence 클래스 import

public class EntityTesAppt01 {
    
    public static void main(String[] args) {
        // EntityManagerFactory를 통해 영속성 유닛을 생성. 이 영속성 유닛의 이름은 "entitytest"로 설정됨.
        // EntityManagerFactory는 애플리케이션이 실행되는 동안 엔티티 매니저를 생성하는데 사용되며, 영속성 유닛의 수명 주기를 관리함.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        
        // EntityManager는 엔티티를 관리하는 주요 인터페이스로, 데이터베이스와의 CRUD 작업을 수행함.
        // 엔티티 매니저는 데이터베이스와 상호작용하며, 엔티티 상태(비영속, 영속, 준영속, 삭제)를 관리함.
        EntityManager manager = factory.createEntityManager();
        
        // EntityTest01 객체 선언
        // 엔티티 클래스는 데이터베이스 테이블의 구조와 매핑되어 있으며, 해당 클래스의 객체는 테이블의 행을 나타냄.
        EntityTest01 entityTest01;
        
        // 트랜잭션 시작. 데이터베이스에 데이터 삽입, 수정, 삭제 작업 시 반드시 트랜잭션이 필요함.
        // 트랜잭션은 데이터 일관성을 보장하며, 작업의 원자성을 유지하기 위해 사용됨.
        manager.getTransaction().begin();

        // @GeneratedValue(strategy = GenerationType.IDENTITY) 설정하기 전의 값
        // 새로운 엔티티 객체를 생성하여 필드 값 설정
        // 이 주석은 ID 값이 수동으로 설정될 때의 코드를 설명함. ID를 수동으로 설정하면 데이터베이스에서 자동으로 생성하지 않음.
        // entityTest01 = new EntityTest01();
        // entityTest01.setId(10); // 기본 키 값 설정
        // 이 코드는 엔티티의 기본 키 값을 명시적으로 설정하는 것으로, 데이터베이스의 자동 증가 기능을 사용하지 않음.
        // entityTest01.setName("홍길동"); // 이름 설정
        // 엔티티의 'name' 필드는 데이터베이스의 특정 열에 매핑됨.
        // entityTest01.setAge(25); // 나이 설정
        // 엔티티의 'age' 필드는 사람의 나이를 나타내며, 기본 데이터 유형으로 int를 사용함.
        // entityTest01.setBirthday(LocalDateTime.now()); // 현재 시간을 생일 값으로 설정. 실제 애플리케이션에서는 사용자의 생일 입력 값을 사용함.
        // LocalDateTime.now()는 현재 시간을 가져오는 메서드로, 필드에 현재 시간을 설정함.
        
        // @GeneratedValue(strategy = GenerationType.IDENTITY) 설정 한 후의 값
        // id 를 @Id 를 통해 pry key 를 하였으므로 id 값 설정 X
        // @GeneratedValue(strategy = GenerationType.IDENTITY)는 데이터베이스가 기본 키 생성을 자동으로 관리함을 의미함.
        for(int i=1; i<=5; i++) { // i는 1부터 5까지 반복하며 각 반복마다 새로운 엔티티를 생성함.
            entityTest01 = new EntityTest01(); // EntityTest01 클래스의 새 인스턴스를 생성.
            entityTest01.setName("홍길동" + i); // '홍길동'에 반복 변수 i를 추가하여 이름 설정. 예: 홍길동1, 홍길동2 등.
            entityTest01.setAge((int)(Math.random()*26) + 25); // 0~25
            // Math.random()은 0.0과 1.0 사이의 난수를 반환함. 여기에 26을 곱하고 25를 더해 나이가 25부터 50 사이의 값을 생성함.
            entityTest01.setBirthday(LocalDateTime.now()); // 현재 시간을 생일로 설정. 테스트 목적으로 현재 시간 사용.
            // 실무에서는 실제 생일 데이터를 사용자가 입력함.
            
            manager.persist(entityTest01); // persist() 메서드는 새 엔티티 객체를 데이터베이스에 저장하기 위해 사용됨.
            // persist()는 엔티티를 영속성 컨텍스트에 저장하고, 트랜잭션이 커밋될 때 데이터베이스에 반영됨.
        } // for
        
        // 트랜잭션 커밋. 데이터베이스에 변경 내용을 적용함.
        // 트랜잭션을 커밋하면, 트랜잭션 내의 모든 변경사항이 데이터베이스에 영구적으로 저장됨.
        manager.getTransaction().commit();
        
        // 엔티티 매니저를 초기화하여 메모리 누수를 방지하고, 열린 영속성 컨텍스트를 닫음.
        manager.clear();
        // 팩토리를 닫아 모든 리소스를 해제하고 애플리케이션이 종료될 때 자원 누수를 방지함.
        factory.close();
    }
}
