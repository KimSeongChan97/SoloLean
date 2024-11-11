package exam.entity;

import java.time.LocalTime; // Java 8 이상에서 시간만을 나타내는 LocalTime 클래스를 사용하기 위한 import입니다.

import jakarta.persistence.Column; // JPA의 @Column 애너테이션을 사용하여 DB 컬럼의 세부 설정을 지정하기 위한 import입니다.
import jakarta.persistence.Entity; // JPA의 @Entity 애너테이션을 사용하여 엔티티 클래스를 지정하기 위한 import입니다.
import jakarta.persistence.GeneratedValue; // ID 생성 전략을 지정하기 위한 @GeneratedValue 애너테이션을 위한 import입니다.
import jakarta.persistence.GenerationType; // ID 생성 전략의 타입을 지정하기 위한 import입니다.
import jakarta.persistence.Id; // JPA의 기본 키를 지정하기 위한 @Id 애너테이션의 import입니다.
import jakarta.persistence.Temporal; // JPA의 @Temporal 애너테이션을 사용하여 java.util.Date의 타입을 명확히 하기 위한 import입니다.
import jakarta.persistence.TemporalType; // @Temporal 애너테이션에 사용되는 TemporalType 열거형을 위한 import입니다.
import lombok.Data; // Lombok의 @Data 애너테이션을 사용하여 getter, setter, toString 등 메서드를 자동으로 생성하기 위한 import입니다.

@Data // Lombok의 @Data 애너테이션은 클래스의 모든 필드에 대해 getter, setter, equals, hashCode, toString 메서드를 자동 생성합니다.
@Entity // @Entity 애너테이션은 이 클래스가 JPA 엔티티임을 나타냅니다. 해당 클래스는 데이터베이스 테이블과 매핑됩니다.
public class EntityTest04 {

	// @GeneratedValue 애너테이션은 기본 키의 자동 생성 전략을 지정합니다.
	// GenerationType.IDENTITY는 데이터베이스에서 자동 증가하는 필드임을 나타냅니다.
	@Id // @Id 애너테이션은 이 필드가 기본 키임을 지정합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; // 엔티티의 기본 키 필드입니다.

	// @Temporal 애너테이션은 java.util.Date 필드의 저장 방식(시간)을 지정합니다. 이 경우, 시간 부분만 저장됩니다.
	@Temporal(TemporalType.TIME) // DB 타입이 time
	private java.util.Date utilTime; // 시간만 저장하는 필드입니다.

	// @Temporal 애너테이션은 java.util.Date 필드의 저장 방식(날짜)을 지정합니다. 이 경우, 날짜 부분만 저장됩니다.
	@Temporal(TemporalType.DATE) // DB 타입이 date
	private java.util.Date utilDate; // 날짜만 저장하는 필드입니다.

	// @Temporal 애너테이션은 java.util.Date 필드의 저장 방식(날짜와 시간)을 지정합니다. 이 경우, 날짜와 시간 모두 저장됩니다.
	@Temporal(TemporalType.TIMESTAMP) 
	private java.util.Date utilTimestamp; // DB 타입이 datetime, 날짜와 시간 모두 저장됩니다.

	private java.util.Date utilPlainDate; // DB 타입이 datetime
	// 이 필드는 @Temporal 애너테이션이 없지만, 기본적으로 날짜와 시간을 모두 포함하는 datetime 타입으로 저장됩니다.

	private java.sql.Date sqlPlainDate; // DB 타입이 time
	// java.sql.Date는 SQL의 DATE 타입과 매핑됩니다. 이 필드는 시간만 저장하는 데 사용될 수 있습니다.

	// @Column 애너테이션의 columnDefinition 속성을 사용하여 DB의 컬럼 정의를 명시적으로 설정할 수 있습니다.
	@Column(columnDefinition = "TIME")
	private LocalTime localTime1; // 이 필드는 시간만 저장되며, DB의 TIME 타입으로 설정됩니다.

	// @Column 이 없는 경우
	// @Column 애너테이션이 없어도 JPA는 이 필드를 DB의 컬럼으로 매핑합니다.
	private LocalTime localTime2; // 이 필드는 JPA의 기본 설정에 따라 시간만 저장됩니다.

	// columnDefinition 속성을 통해 DB의 DATE 타입으로 설정됩니다.
	@Column(columnDefinition = "DATE")
	private LocalTime localDate1; // 이 필드는 날짜만 저장되며, DB의 DATE 타입으로 설정됩니다.

	// @Column 이 없는 경우
	// @Column 애너테이션이 없어도 JPA는 이 필드를 DB의 컬럼으로 매핑합니다.
	private LocalTime localDate2; // 이 필드는 JPA의 기본 설정에 따라 날짜만 저장됩니다.

	// columnDefinition 속성을 통해 DB의 TIMESTAMP 타입으로 설정됩니다.
	@Column(columnDefinition = "TIMESTAMP")
	private LocalTime localDateTime1; // 이 필드는 날짜와 시간을 모두 저장하며, DB의 TIMESTAMP 타입으로 설정됩니다.

	// @Column 이 없는 경우
	// @Column 애너테이션이 없어도 JPA는 이 필드를 DB의 컬럼으로 매핑합니다.
	private LocalTime localDateTime2; // 이 필드는 JPA의 기본 설정에 따라 날짜와 시간을 저장하는 datetime 타입으로 저장됩니다.
}
