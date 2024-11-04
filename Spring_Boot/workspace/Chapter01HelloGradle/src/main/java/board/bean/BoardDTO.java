package board.bean;

import java.util.Date;
import lombok.Data;

@Data
public class BoardDTO {

     private int seq;
     private String name;
     private String subject;
     private String content;
     private Date logtime;
     
}
