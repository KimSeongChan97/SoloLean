package member.bean;

import lombok.Data;
import java.util.Date;

@Data
public class MemberDTO {
    private String name;     // 이름
    private String id;       // 아이디 (Primary Key)
    private String pwd;      // 비밀번호
    private String gender;   // 성별
    private String email1;   // 이메일1
    private String email2;   // 이메일2
    private String tel1;     // 전화번호1
    private String tel2;     // 전화번호2
    private String tel3;     // 전화번호3
    private String zipcode;  // 우편번호
    private String addr1;    // 주소1
    private String addr2;    // 주소2
    private Date logtime;    // 로그인 시간
}
