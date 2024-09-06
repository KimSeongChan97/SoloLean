package board.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {
	private int seq; // 글번호
    private String id; // 아이디
    private String name; // 이름
    private String subject; // 제목
    private String content; // 내용
    private Date logtime; // 날짜
    
    
}
