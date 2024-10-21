package questions.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class QuestionsDTO {
    
    private int questionsId;    // 질문 ID (INT, AUTO_INCREMENT, PRIMARY KEY)
    private int userId;         // user 테이블의 seq (INT, NOT NULL)
    private Integer adminId;    // 답변자 ID (INT, NULL)
    private String content;     // 문의 내용 (TEXT, NOT NULL)
    private int qtypesId;       // 문의 유형 ID (INT, DEFAULT '기타')
    private boolean isAnswered; // 답변 여부 (BOOLEAN, DEFAULT FALSE)
    private String logtime;     // 문의 작성 날짜 (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
    private String updatetime;  // 문의 수정 시간 (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP ON UPDATE)
    private String typename;     // 문의 유형 이름 추가
    private String writerId;	//작성자 user_id 추가
    private String userName;	//작성자 userName 추가
    private int seq;	//작성자 seq 추가
}