package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Browser 에 바로 뿌린다 
@RestController
public class BoardController {
		
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/board/write")
	public String write() {
		boardService.write();
		return "등록 성공"; // 문자열 반환 이므로 String 으로 적용
	};
	
	@GetMapping(value = "/board/list")
	public List<BoardEntity> list() {
		return boardService.list(); // 최신순 내림차순(seq)으로 sort 하여 JSON 형식으로 브라우저에 값을 도출한다.
	};
	
}
