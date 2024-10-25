package room.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ReserveDTO {

    private int reserveId;     // 예약 ID (INT, AUTO_INCREMENT, PRIMARY KEY)
    private int userId;        // 사용자 ID (INT)
    private int roomId;        // 방 ID (INT))
    private int adults;        // 어른 수 (INT)
    private int kids;          // 아이 수 (INT)
    private String checkin;    // 체크인 날짜 (DATE)
    private String checkout;   // 체크아웃 날짜 (DATE)
    private int price;         // 가격 (INT)
    private String time;       // 예약 시간 (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)
    
    private RoomDTO room;	  // RoomDTO 추가
    private RoomImgDTO roomImgDTO;
    private int days;
}
