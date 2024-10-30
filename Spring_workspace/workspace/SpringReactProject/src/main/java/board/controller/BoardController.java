package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;
import board.service.BoardService;

@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
//@Controller
@RestController
@RequestMapping("board")
public class BoardController {
	
    @Autowired
    private BoardService boardService;
    
    @PostMapping(value="boardWrite")
    //@ResponseBody
    public void boardWrite(@RequestParam String subject, @RequestParam String content) {
        System.out.println(subject);
        
        boardService.boardWrite(subject, content);
        
    }
    
    @GetMapping(value="BoardList")
    //@ResponseBody
    public List<BoardDTO> BoardList() {
    	// List<BoardDTO> 객체를 자동으로 JSON 배열로 변환하여 보낸다.
    	List<BoardDTO> list = boardService.BoardList();
		// System.out.println(list); // [BoardDTO(~~), BoardDTO(~~), BoardDTO(~~) ... ]
        return boardService.BoardList();
    }
    
    @GetMapping(value="BoardDetail")
    //@ResponseBody
    public BoardDTO BoardDetail(@RequestParam int seq) {
    	boardService.HitCount(seq);
        return boardService.BoardDetail(seq);
    }

    
}
