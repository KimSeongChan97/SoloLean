package board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@CrossOrigin(origins = "http://localhost:3000") // CORS 설정: React 클라이언트에서의 요청 허용
@RestController // RESTful 웹 서비스를 만들기 위한 컨트롤러임을 선언
@RequestMapping("/board2") // 공통된 URL 경로 매핑
public class Board2Controller {
		
	private List<BoardDTO> list = new ArrayList<>(); // 게시글을 저장할 리스트, 메모리 내에서 데이터를 유지
	
	@PostMapping("/boardInput") // POST 요청을 받아들여 새 게시글을 추가하는 메서드
	public String boardInput(@RequestBody BoardDTO boardDTO) {
		boardDTO.setSeq(list.size() + 1); // 게시글 번호를 설정, 현재 리스트 크기 + 1
		boardDTO.setLogtime(new Date()); // 현재 시간을 게시글 생성 시간으로 설정
		list.add(0, boardDTO); // 리스트의 맨 앞에 새 게시글 추가 (최신 글이 맨 위로 오도록)
		return "success";
	};
	
	@GetMapping("/boardList") // GET 요청을 받아 모든 게시글 목록을 반환하는 메서드
	public List<BoardDTO> boardList() {
		return list;
	};
}
