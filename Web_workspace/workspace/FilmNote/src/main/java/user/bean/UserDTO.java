// FilmNote/src/main/java/user/bean/UserDTO.java
package user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String uid;      // 아이디
    private String upwd;     // 비밀번호
    private String uname;    // 이름
    private String gender;   // 성별: F/M
    private String birth1;   // 생년월일(년): YYYY
    private String birth2;   // 생년월일(월): MM
    private String birth3;   // 생년월일(일): DD
    private String email1;   // 이메일1
    private String email2;   // 이메일2
    private String tel1;     // 휴대폰1
    private String tel2;     // 휴대폰2
    private String tel3;     // 휴대폰3
}

