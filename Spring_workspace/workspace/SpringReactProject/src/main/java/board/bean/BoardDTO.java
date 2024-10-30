package board.bean;

import lombok.Data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


@Data
public class BoardDTO {
    private int seq;
    private String id;
    private String name; 
    private String email; 
    private String subject; 
    private String content;
    private int ref; 
    private int lev; 
    private int step;
    private int pseq; 
    private int reply; 
    private int hit;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd") // Jackson 에서 제공
    private Date logtime;
    
}
