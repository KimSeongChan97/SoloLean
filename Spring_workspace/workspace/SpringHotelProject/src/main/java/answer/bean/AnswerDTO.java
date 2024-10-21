package answer.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AnswerDTO {

    private int answerId;       // 답변 ID (INT, AUTO_INCREMENT, PRIMARY KEY)
    private int questionsId;     // 질문 ID (INT, NOT NULL, Foreign Key to questions)
    private int userId;         // 답변한 사람의 ID (INT, NOT NULL, Foreign Key to user)
    private String adminId;         // 답변한 사람의 ID (INT, NOT NULL, Foreign Key to user)
    private String comment;     // 답변 내용 (TEXT, NOT NULL)
    private String logdate;     // 답변 작성 날짜 (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
}
