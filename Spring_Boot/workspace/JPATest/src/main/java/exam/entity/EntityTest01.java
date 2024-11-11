package exam.entity;

import java.time.LocalDateTime; // Java의 날짜와 시간을 다루기 위한 클래스. LocalDateTime은 날짜와 시간을 함께 표현할 수 있음.

import jakarta.persistence.Entity; // JPA에서 해당 클래스가 엔티티임을 지정하기 위해 사용. 이 클래스는 데이터베이스의 테이블과 매핑됨.
import jakarta.persistence.GeneratedValue; // 기본 키 값의 자동 생성을 지원하기 위해 사용.
import jakarta.persistence.GenerationType; // 기본 키 생성 전략을 지정할 때 사용. 예를 들어, IDENTITY 전략은 데이터베이스의 auto_increment 기능을 사용함.
import jakarta.persistence.Id; // JPA에서 기본 키 필드를 지정하기 위해 사용.
import jakarta.persistence.Table; // 엔티티와 데이터베이스의 테이블을 매핑하기 위해 사용.
import lombok.Data; // Lombok 라이브러리에서 제공하는 어노테이션으로, 자동으로 getter, setter, toString, equals, hashCode 메서드를 생성함.

@Data // @Data는 Lombok의 어노테이션으로, 클래스 내의 모든 필드에 대해 getter와 setter를 자동 생성하고, toString, equals, hashCode 메서드도 자동 생성함.
// 이 어노테이션을 사용하면 코드의 간결성을 높일 수 있음.
@Entity // @Entity는 JPA에서 이 클래스가 데이터베이스의 테이블과 매핑되는 엔티티임을 나타냄.
// 데이터베이스 테이블의 행(row)은 이 클래스의 인스턴스에 해당함.
@Table(name="entitytesttlb") // @Table 어노테이션은 엔티티 클래스와 매핑되는 실제 테이블의 이름을 지정. 여기서는 "entitytesttlb" 테이블에 매핑됨.
public class EntityTest01 {
    
    @Id // @Id는 이 필드가 테이블의 기본 키(primary key)임을 지정한다.
    // 기본 키는 테이블에서 각 행을 고유하게 식별하기 위한 필드임.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment, pri key 값을 자동 증가로 만들어줌
    // @GeneratedValue는 기본 키 생성 전략을 설정. IDENTITY는 데이터베이스에서 기본 키 생성을 자동으로 관리함. 즉, 새로운 엔티티가 추가될 때마다 ID가 자동으로 증가.
    private int id; // 기본 키 필드로, 데이터베이스의 auto_increment 기능을 통해 자동으로 값이 증가함.
    
    private String name; // 엔티티의 'name' 필드. 이 필드는 데이터베이스 테이블의 열(column)에 매핑됨.
    // 이름을 나타내며, 데이터 타입은 String으로 지정됨.
    
    private int age; // 'age' 필드는 사람의 나이를 저장하는 정수형 데이터로, 테이블의 열(column)에 매핑됨.
    // 엔티티 객체 생성 시 나이를 설정하여 데이터베이스에 저장할 수 있음.
    
    private LocalDateTime birthday; // 'birthday' 필드는 사용자의 생년월일을 저장하며, LocalDateTime 클래스를 사용하여 날짜와 시간을 표현.
    // LocalDateTime은 날짜와 시간을 다룰 수 있어 시간 기반 데이터를 다루기에 적합함.
    
};
