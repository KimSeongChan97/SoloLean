package exam.entity;

// JPA 관련 라이브러리에서 제공하는 어노테이션들을 가져옵니다.
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// Lombok 라이브러리를 사용하여 getter/setter, toString 등의 메서드를 자동으로 생성합니다.
import lombok.Data;

@Data // Lombok 어노테이션으로, 이 어노테이션을 붙이면 모든 필드에 대해 getter, setter, toString, equals, hashCode 메서드가 자동으로 생성됩니다.
@Entity // JPA에서 이 클래스를 데이터베이스의 테이블과 매핑하기 위한 어노테이션입니다. 이 클래스는 "Team"이라는 테이블을 나타내는 Entity입니다.
public class Team {
	
	@Id // @Id는 이 필드가 테이블의 기본 키(PK)임을 나타냅니다. 기본 키는 데이터베이스에서 각 레코드를 고유하게 식별하기 위해 사용됩니다.
	@Column(name = "TEAM_ID") // @Column 어노테이션으로, 테이블에서 이 필드와 매핑될 실제 컬럼 이름을 "TEAM_ID"로 지정합니다. 즉, 데이터베이스 테이블에 "TEAM_ID"라는 컬럼과 연결됩니다.
	private String id; // PK - 이 필드는 Team 테이블의 기본 키로 사용됩니다. 데이터베이스에서 이 값은 고유해야 합니다.
	
	private String name; // 팀의 이름을 나타내는 필드입니다. 컬럼 이름을 지정하지 않았으므로, name이라는 이름으로 매핑됩니다.
	
	// @Data 어노테이션이 있기 때문에 getter/setter 메서드와 toString, equals 메서드가 자동으로 생성됩니다.
	// 따라서 별도로 메서드를 작성하지 않아도 id와 name 필드에 접근할 수 있습니다.
}
