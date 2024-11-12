package exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Dept {
    
    @Id // 기본 키(primary key) 설정
    private int depno; // 부서 번호
    
    @Column(length = 20) // dname 컬럼의 최대 길이를 20으로 설정
    private String dname; // 부서 이름
    
    // 연관 매핑
    @ManyToOne // 다대일 관계 설정, 각 부서는 하나의 Locations에 매핑
    @JoinColumn(name = "loc_code", referencedColumnName = "loc_code") 
    // loc_code는 외래 키로 사용하며, 참조하는 테이블(Locations)의 loc_code를 매핑
    private Locations loc_code; // 부서와 지역 정보를 연결, Locations 엔티티 참조
    
    
}
