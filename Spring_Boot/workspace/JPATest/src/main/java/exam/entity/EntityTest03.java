package exam.entity;

import java.math.BigDecimal; // 고정 소수점 연산을 위해 사용하는 클래스입니다.

import jakarta.persistence.Column; // JPA의 @Column 애너테이션을 사용하여 DB 컬럼의 세부 설정을 지정하기 위한 import입니다.
import jakarta.persistence.Entity; // JPA의 @Entity 애너테이션을 사용하여 엔티티 클래스를 지정하기 위한 import입니다.
import jakarta.persistence.GeneratedValue; // ID 생성 전략을 지정하기 위한 @GeneratedValue 애너테이션을 위한 import입니다.
import jakarta.persistence.GenerationType; // ID 생성 전략의 타입을 지정하기 위한 import입니다.
import jakarta.persistence.Id; // JPA의 기본 키를 지정하기 위한 @Id 애너테이션의 import입니다.
import jakarta.persistence.Lob; // 대용량 데이터 컬럼을 위한 @Lob 애너테이션을 위한 import입니다.
import lombok.Data; // Lombok의 @Data 애너테이션을 사용하여 getter, setter, toString 등 메서드를 자동으로 생성하기 위한 import입니다.

@Data // Lombok의 @Data 애너테이션은 클래스의 모든 필드에 대해 getter, setter, equals, hashCode, toString 메서드를 자동 생성합니다.
@Entity // @Entity 애너테이션은 이 클래스가 JPA 엔티티임을 나타냅니다. 해당 클래스는 데이터베이스 테이블과 매핑됩니다.
public class EntityTest03 {
		
	// @GeneratedValue 애너테이션은 기본 키의 자동 생성 전략을 지정합니다.
	// GenerationType.IDENTITY는 데이터베이스에서 자동 증가하는 필드임을 나타냅니다.
	@Id // @Id 애너테이션은 이 필드가 기본 키임을 지정합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; // 엔티티의 기본 키 필드입니다.

	// @Column 애너테이션은 이 필드가 DB의 컬럼과 매핑될 때 세부 속성을 정의합니다.
	// nullable = false는 이 컬럼이 NULL 값을 허용하지 않음을 나타내며, length = 10은 최대 길이를 10자로 제한합니다.
	@Column(nullable = false, length = 10) 
	private String name; // 엔티티의 name 필드입니다. 이 필드는 비어 있을 수 없습니다.

	// columnDefinition 속성은 데이터베이스 컬럼의 정의를 지정합니다.
	// 이 경우, 이 컬럼은 기본 값이 '파랑'인 varchar(20) 타입으로 설정됩니다.
	@Column(columnDefinition = "varchar(20) default '파랑'") 
	private String favoriteColor; // 엔티티의 favoriteColor 필드입니다.

	// DB에 'age'라는 이름의 컬럼과 매핑됩니다.
	// nullable = false는 이 컬럼이 NULL 값을 허용하지 않음을 나타냅니다.
	@Column(name = "age", nullable = false)
	private int num1; // 엔티티의 필드명은 num1이지만, 데이터베이스에서는 'age'라는 이름의 컬럼으로 저장됩니다.

	// precision = 6은 전체 자리 수를, scale = 2는 소수점 이하 자리 수를 나타냅니다.
	// 이 설정은 score 컬럼이 최대 9999.99처럼 총 6자리 중 소수점 이하 2자리를 가질 수 있음을 의미합니다.
	// 숫자가 6개, 소수이하 자리수 2자리, 9999.99
	@Column(name = "score", precision = 6, scale = 2)
	private BigDecimal num2; // 엔티티의 num2 필드입니다. 고정 소수점 수를 저장하기 위해 사용됩니다.

	@Lob // @Lob 애너테이션은 대용량 데이터 컬럼을 나타냅니다.
	private byte[] content1; // 이 필드는 대용량 바이너리 데이터를 저장할 수 있습니다.

	@Lob // @Lob 애너테이션은 대용량 데이터 컬럼을 나타냅니다.
	private char[] content2; // 이 필드는 대용량 문자 데이터를 저장할 수 있습니다.

	@Lob // @Lob 애너테이션은 대용량 데이터 컬럼을 나타냅니다.
	private String content3; // 이 필드는 대용량 문자열 데이터를 저장할 수 있습니다.
	
	
	
}
