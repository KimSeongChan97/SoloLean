package admin.bean;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AdminDTO {
	
	private int seq;
    private String adminId;    // 아이디 (VARCHAR(30), PRIMARY KEY)
    private String pwd;   // 비밀번호 (VARCHAR(70), NOT NULL)
    private String name;  // 이름 (VARCHAR(30), NOT NULL)
}
