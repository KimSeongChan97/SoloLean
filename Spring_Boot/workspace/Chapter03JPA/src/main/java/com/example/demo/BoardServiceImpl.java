package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void write() {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setId("melon");
		boardEntity.setName("멜론");
		boardEntity.setSubject("멜론덩이");
		boardEntity.setContent("멜론은 맛있고 부드러운 겁니다");
		
		// DB 에 저장
		boardDAO.save(boardEntity);		
		
	};
	
	@Override
	public List<BoardEntity> list() {
		return boardDAO.findAllByOrderBySeqDesc();	
	};
	// Hibernate: select be1_0.seq,be1_0.content,be1_0.id,be1_0.logtime,be1_0.name,be1_0.subject from boardtbl be1_0 order by be1_0.seq desc
	
	
}
