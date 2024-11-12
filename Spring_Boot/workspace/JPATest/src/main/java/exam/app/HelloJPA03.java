package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA03 {

    public static void main(String[] args) throws EntityNotFoundException, InterruptedException {
        
        // EntityManagerFactory 객체를 생성하여 데이터베이스 연결 설정 정보를 로드합니다.
        // "entitytest"는 persistence.xml 파일에 정의된 persistence unit 이름입니다.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        
        // EntityManager 객체를 생성하여 데이터베이스와의 작업을 수행하는 엔티티 관리자입니다.
        EntityManager manager = factory.createEntityManager();
        
        // JPQL을 사용해 Emp 엔티티의 모든 객체를 가져오는 쿼리 생성
        // "select emp from Emp emp"은 JPQL 쿼리문으로, Emp 엔티티의 모든 레코드를 조회합니다.
        // Emp는 엔티티 클래스이기 때문에 테이블 이름 대신 엔티티 이름을 사용합니다.
        // Query 객체는 JPQL 쿼리를 데이터베이스에 전달하기 위한 객체입니다.
        Query query = manager.createQuery("select emp from Emp emp", Emp.class); // JPQL, Emp 은 Entity Class 이다.
        
        // 쿼리를 실행하여 Emp 엔티티 객체들의 리스트를 가져옵니다.
        // getResultList()는 JPQL 쿼리 실행 결과를 List 타입으로 반환합니다.
        List<Emp> list = query.getResultList();
        
        System.out.println();
        
        // 조회된 모든 Emp 객체에 대해 직원명과 부서명을 출력
        // for-each 문을 통해 조회된 각 Emp 객체를 순회하며 직원명과 부서명을 출력합니다.
        for(Emp emp : list) {
            // emp.getEname()을 통해 Emp 객체의 직원명을 가져와 출력합니다.
            System.out.println("직원명 : " + emp.getEname());
            
            // 1초 간격으로 출력되도록 딜레이를 설정합니다.
            Thread.sleep(1000);
            
            // emp.getDeptno()가 null이 아닐 경우, 부서명을 출력
            // emp.getDeptno()는 Emp 객체가 속한 부서 정보를 반환합니다.
            // 부서 정보가 null인지 검사하여 null이 아닐 경우 부서명을 가져와 출력합니다.
            if(emp.getDeptno() != null) { 
                // emp.getDeptno().getDname()을 통해 부서명을 가져와 출력합니다.
                System.out.println(" 부서명 : " + emp.getDeptno().getDname());
                System.out.println();
            } else {
                // emp.getDeptno()가 null일 경우, 부서명이 없음을 알리는 메시지를 출력합니다.
                System.out.println(" 부서명 : 없음 "); // 부서 정보가 없을 때 출력
                System.out.println();
            } // if
        } // for

        System.out.println("데이터 총 갯수 = " + list.size());

        manager.close();
        factory.close();
    }

}
