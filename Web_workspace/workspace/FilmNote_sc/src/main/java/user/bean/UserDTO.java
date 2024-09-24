// FilmNote/src/main/java/user.bean.UserDTO.java
package user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String id;        // 회원 아이디
    private String pwd;       // 회원 비밀번호
    private String name;      // 회원 이름
    private String gender;    // 성별
    private String birth1;    // 생년 (YYYY)
    private String birth2;    // 생월 (MM)
    private String birth3;    // 생일 (DD)
    private String email1;    // 이메일 아이디
    private String email2;    // 이메일 도메인
    private String tel1;      // 휴대폰 앞자리
    private String tel2;      // 휴대폰 가운데 자리
    private String tel3;      // 휴대폰 끝자리
}
