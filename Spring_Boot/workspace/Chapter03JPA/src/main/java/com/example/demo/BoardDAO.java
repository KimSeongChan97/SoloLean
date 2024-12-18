package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer> {
	
	// 쿼리 메서드
	public BoardEntity findBySeq(int seq);
	
	public List<BoardEntity> findByLogtimeNull();
	
	public List<BoardEntity> findByIdContaining(String key);

	public List<BoardEntity> findByLogtimeAfter(LocalDateTime localDateTime);
	//public List<BoardEntity> findByLogtimeAfter(Date valueOf);

	public List<BoardEntity> findBySeqBetween(int i, int j);

	public List<BoardEntity> findAllByOrderBySeqDesc();
	

	

}
