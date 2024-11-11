package exam.app;


import java.util.List;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTesAppt05 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		System.out.println(" 엔 티 티 삭 제 !! ");
		
		// primary key가 5인 EntityTest01 객체를 데이터베이스에서 찾습니다.
		EntityTest01 entityTest01 = manager.find(EntityTest01.class, 5);
		// 해당 엔티티를 데이터베이스에서 제거합니다. remove() 메서드는 영속성 컨텍스트에 있는 엔티티를 제거할 때 사용됩니다.
		manager.remove(entityTest01);
		
		TypedQuery<EntityTest01> q = manager.createQuery("SELECT p FROM EntityTest01 p", EntityTest01.class);
		List<EntityTest01> list = q.getResultList();
		list.stream().forEach(System.out::println);		
		
		manager.getTransaction().commit();
		manager.close(); 
		factory.close();

	}

}
