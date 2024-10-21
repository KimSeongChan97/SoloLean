package room.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RoomImgDTO {
    private int roomImgId;
    private int roomId;
    private String imageFileName;
    private String imageOriginalFileName;


}
