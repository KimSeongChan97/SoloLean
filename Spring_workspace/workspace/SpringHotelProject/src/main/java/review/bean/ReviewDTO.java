package review.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ReviewDTO {

    private int reviewId;      // 리뷰 고유 ID (INT, AUTO_INCREMENT, PRIMARY KEY)
    private int roomId;        // 해당 리뷰가 속한 객실 ID (INT, NOT NULL)
    private Integer userId;    // 리뷰를 작성한 사용자 ID (INT, NULL 가능)
    private String userName;   // 사용자 이름 (추가)
    private int rating;        // 리뷰 점수 (INT, 1~5 사이)
    private String comment;    // 리뷰 내용 (TEXT)
    private String logtime;    // 리뷰 작성 날짜 (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
    private String updatetime; // 리뷰 수정 날짜 (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP ON UPDATE)
}
