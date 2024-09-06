package member.bean;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Data
public class MemberDTO {
	// 필드 선언 : member 테이블의 컬럼
	private String name;
	private String id;
	private String pwd;
	private String phone;
	@Override
	public String toString() {
		return name + "\t" 
				+ id + "\t"
				+ pwd + "\t"
				+ phone + "\t";
	}
	
}
