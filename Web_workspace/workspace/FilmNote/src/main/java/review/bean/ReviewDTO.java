// FilmNote/src/main/java/review/bean/ReviewDTO.java
package review.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {
    private int rcode;           // 리뷰 코드
    private int movie_code;      // 영화 코드 (참조하는 영화의 코드)
    private String user_id;      // 작성자 아이디
    private String content;      // 리뷰 내용
    private String logtime;      // 작성 시간 YYYY-MM-DD hh:mm:ss
    private int score;		 // 별점
}

