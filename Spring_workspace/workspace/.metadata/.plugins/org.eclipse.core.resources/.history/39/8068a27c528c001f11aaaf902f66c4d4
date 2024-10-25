package room.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RoomDTO {

    private int roomId;        // 객실 ID (INT, AUTO_INCREMENT, PRIMARY KEY)
    private String type;       // 객실 형태 (VARCHAR(20), NOT NULL)
    private int size;          // 객실 크기 (INT, NOT NULL)
    private int capacity;      // 객실 수용 인원 (INT, NOT NULL)
    private int price;         // 객실 1박 가격 (INT, NOT NULL)
    private int count;         // 객실 총 개수 (INT, NOT NULL)
    private String description;// 객실 설명 (TEXT, NOT NULL)
    private String form;       // 객실 구성 (TEXT, NOT NULL)
    private String view;       // 객실 전망 (TEXT, NOT NULL)
    private String bedtype;    // 침대 타입 (TEXT, NOT NULL)
    
    private RoomImgDTO roomImg;
}
