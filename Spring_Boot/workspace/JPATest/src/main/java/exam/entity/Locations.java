package exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Locations {

    @Id // 기본 키(primary key) 설정
    @Column(columnDefinition = "char(2)") // loc_code 컬럼을 문자형(char) 2자리로 정의
    private String loc_code; // 지역 코드
    
    @Column(length = 20) // city 컬럼의 최대 길이를 20으로 설정
    private String city; // 도시 이름, 예를 들어 Seoul 등
    
}
