package exam.entity;

// JPA 관련 라이브러리에서 제공하는 어노테이션을 가져옵니다.
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data // Lombok 어노테이션으로, getter/setter 메서드 및 toString, equals, hashCode 등을 자동으로 생성합니다.
@Entity // JPA에서 이 클래스를 데이터베이스의 테이블과 매핑하기 위한 어노테이션입니다. 이 클래스는 "EntityTest05"라는 테이블을 나타내는 Entity입니다.
public class EntityTest05 {
	
	@Id // @Id는 이 필드가 테이블의 기본 키(PK)임을 나타냅니다. 기본 키는 데이터베이스에서 각 레코드를 고유하게 식별하기 위해 사용됩니다.
	private int id; // 이 필드는 EntityTest05 테이블의 기본 키로 사용되며, 정수형의 값으로 고유해야 합니다.
	
	private String username; // 사용자의 이름을 나타내는 필드입니다. 데이터베이스 테이블에서 username이라는 이름으로 매핑됩니다.
	
	// 연관 관계 매핑 ( join )
	// 객체지향 프로그래밍에서는 각 객체 간의 관계를 직접적으로 연결할 수 있지만,
	// 관계형 데이터베이스에서는 외래 키(Foreign Key)를 통해 두 테이블을 연결합니다.
	
	// 다 대 일
	@ManyToOne // @ManyToOne은 다대일(N:1) 관계를 나타내며, 여러 EntityTest05 객체가 하나의 Team 객체와 연관될 수 있음을 의미합니다.
	private Team t; // FK - 이 필드는 외래 키(Foreign Key) 역할을 하며, Team 테이블의 기본 키를 참조합니다.
	// 이 외래 키는 데이터베이스에서 테이블을 조인하는 데 사용되며,
	// DB의 필드명은 t_TEAM_ID로 자동 생성됩니다.
	// FK_PK 으로 만들어진다 - 외래 키와 기본 키가 결합되어 해당 필드가 팀과 연결됨을 표시합니다.
	// 자동부여가 싫으면 @joinColumn 으로 필드 명을 지정하면 된다. - 필드명을 직접 지정하여 외래 키 명을 커스터마이징할 수 있습니다.
	
	// 기본 생성자 - 매개변수가 없는 생성자를 만듭니다. JPA는 내부적으로 리플렉션을 통해 객체를 생성하기 때문에 기본 생성자가 필요합니다.
	public EntityTest05() {}; // default
	
	// 매개변수가 있는 생성자 - 특정 username과 Team 객체를 받아서 EntityTest05 객체를 초기화할 때 사용됩니다.
	public EntityTest05(String username, Team team) {
		this.username = username; // 매개변수로 받은 username을 필드에 저장합니다.
		t = team; // 매개변수로 받은 Team 객체를 필드에 저장합니다.
	};
	
}
