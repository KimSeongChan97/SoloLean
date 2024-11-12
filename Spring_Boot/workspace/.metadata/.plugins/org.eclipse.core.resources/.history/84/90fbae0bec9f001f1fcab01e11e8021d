package exam.entity;

import java.time.LocalDateTime; // 날짜와 시간을 나타내기 위한 LocalDateTime 클래스 import

import jakarta.persistence.Entity; // JPA에서 Entity를 사용하기 위한 import
import jakarta.persistence.Id; // 엔티티의 기본 키를 지정하기 위한 import
import jakarta.persistence.Table; // 엔티티와 데이터베이스 테이블 간의 매핑을 위한 import
import lombok.Data; 

@Data 
@Entity // JPA의 @Entity 어노테이션은 이 클래스가 데이터베이스 테이블과 매핑되는 엔티티 클래스임을 나타낸다.
@Table(name="entitytesttlb") // @Table은 이 클래스가 매핑될 데이터베이스 테이블의 이름을 지정한다. 여기서는 "entitytesttlb"라는 테이블에 매핑됨.
public class EntityTest01 {
    
    @Id // @Id는 이 필드가 테이블의 기본 키(primary key)임을 지정한다.
    private int id; // 데이터베이스 테이블의 기본 키로 사용할 필드. 필드 타입은 int.
    private String name; // 사용자 이름을 저장하는 필드.
    private int age; // 사용자의 나이를 저장하는 필드.
    private LocalDateTime birthday; // 사용자의 생일을 저장하기 위한 필드. LocalDateTime 타입으로 날짜와 시간을 함께 저장할 수 있다.
}
