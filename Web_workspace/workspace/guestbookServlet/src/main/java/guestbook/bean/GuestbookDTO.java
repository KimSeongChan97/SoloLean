package guestbook.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestbookDTO {
	private int seq; // 방명록 글의 고유 식별번호 , DB의 seq 필드와 매핑됨 (자동으로 증가)
	private String name; // 글 작성자의 이름
	private String email; // 사용자가 입력한 이메일
	private String homepage; // 사용자가 입력한 홈페이지 url
	private String subject; // 사용자가 입력한 글의 제목
	private String content; // 사용자가 입력한 글의 내용
	private Date logtime; // db 의 sysdate 값
	
	@Override
	public String toString() {
		return seq + "\t"
			 + name + "\t"
			 + email + "\t"
			 + homepage + "\t"
			 + subject + "\t"
			 + content;
	}
}






