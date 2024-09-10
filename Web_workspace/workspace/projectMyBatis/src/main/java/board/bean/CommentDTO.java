package board.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	 	private int commentSeq;  // 댓글 고유 번호
	    private int boardSeq;    // 게시물 고유 번호
	    private String name;
	    private String content;  // 댓글 내용
	    private String writer;   // 댓글 작성자
	    private Date logtime;    // 댓글 작성 시간
}
