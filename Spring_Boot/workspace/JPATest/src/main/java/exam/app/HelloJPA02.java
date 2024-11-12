package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA02 {

    public static void main(String[] args) {
        // EntityManagerFactory: EntityManager를 생성하는 팩토리 클래스
        // entitytest라는 Persistence Unit을 사용해 팩토리 객체를 생성
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        
        // EntityManager: 데이터베이스와의 CRUD 작업을 담당
        EntityManager manager = factory.createEntityManager();
        
        // JPQL 쿼리를 사용해 Emp 엔티티의 모든 객체를 가져오는 쿼리 생성
        // Query query = manager.createQuery("select * from 테이블객체", 테이블.클래스);
        
        // Emp 엔티티의 모든 레코드를 조회하는 JPQL 쿼리를 생성
        // select emp from Emp emp: Emp 엔티티의 모든 객체를 emp 별칭을 통해 가져옴
        // Emp.class: 쿼리의 결과가 Emp 클래스 타입임을 지정하여 안전한 타입을 보장
        Query query = manager.createQuery("select emp from Emp emp", Emp.class); // JPQL, Emp 은 Entity Class 이다.
        
        // 쿼리 결과를 리스트 형태로 받아와 Emp 객체 리스트 생성
        List<Emp> list = query.getResultList();
        
        // for문을 통해 리스트에 저장된 모든 Emp 객체의 ename 필드를 출력
        for(Emp emp : list) {
            // emp.getEname(): 각 Emp 객체의 이름(ename)을 출력
            System.out.println(emp.getEname());
        } // for
        
        // 총 레코드 개수를 출력
        System.out.println("데이터 총 갯수 = " + list.size());

        manager.close();
        factory.close();
    }

}
