package user.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {
	private int seq;
    private String userId;         // 아이디 (varchar(30) - primary key)
    private String pwd;        // 비밀번호 (varchar(70) - not null)
    private String name;       // 이름 (varchar(30) - not null)
    private String gender;     // 성별 (varchar(3) - not null, F/M)
    private int birth1;     // 생년(년) (varchar(10) - not null, YYYY)
    private int birth2;     // 생월(월) (varchar(10) - not null, MM)
    private int birth3;     // 생일(일) (varchar(10) - not null, DD)
    private String email;      // 이메일 (varchar(20) - not null)
    private boolean emailCheck; // 이메일 인증 여부 (BOOLEAN, default: false)
    private String tel1;       // 휴대폰1 (varchar(10))
    private String tel2;       // 휴대폰2 (varchar(10))
    private String tel3;       // 휴대폰3 (varchar(10))
    private String grade;      // 회원 등급 (varchar(50), default: '일반')
    private String logintype;  // 로그인 타입 (varchar(10), default: 'SH')
}
