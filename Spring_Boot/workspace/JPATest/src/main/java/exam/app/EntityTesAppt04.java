package exam.app;

import java.time.LocalDateTime;
import java.util.List;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTesAppt04 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		EntityTest01 entityTest01;
		
		manager.getTransaction().begin(); // 트랜잭션 시작, [ 데이터 삽입, 수정, 삭제 시 필수 ]
		
		for(int i=1; i<=5; i++) { 
            entityTest01 = new EntityTest01(); 
            entityTest01.setName("또치" + i); 
            entityTest01.setAge((int)(Math.random()*26) + 25); 
            entityTest01.setBirthday(LocalDateTime.now());
            manager.persist(entityTest01); 
        } // for
		
		TypedQuery<EntityTest01> q = manager.createQuery("SELECT p FROM EntityTest01 p", EntityTest01.class);
		List<EntityTest01> list = q.getResultList();
		list.stream().forEach(System.out::println);		
		
		manager.flush();
		System.out.println("flush");
		q = manager.createQuery("SELECT p FROM EntityTest01 p", EntityTest01.class);
		list = q.getResultList();
		list.stream().forEach(System.out::println);
		
		manager.getTransaction().rollback();
		System.out.println("rollback");
		q = manager.createQuery("SELECT p FROM EntityTest01 p", EntityTest01.class);
		list = q.getResultList();
		list.stream().forEach(System.out::println);
		
		//manager.getTransaction().commit(); // 트랜잭션 커밋. 데이터베이스에 변경 내용 적용.
		
		manager.close(); 
		factory.close();

	}

}
