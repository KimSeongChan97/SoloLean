package board.service;

import java.text.SimpleDateFormat;
import java.util.List;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListService implements Board {

	@Override
	public void execute() {
		 BoardDAO boardDAO = new BoardDAO(); // DAO 객체 생성
	     List<BoardDTO> list = boardDAO.list(); // DAO의 list 메서드를 호출하여 게시글 목록을 가져옴
	     
	     //날짜 yyyy.MM.dd
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
	     //헤더
	     System.out.println("--------------------------------");
	     System.out.println("글번호\t제목\t아이디\t날짜");
	     System.out.println("--------------------------------");
	     
	     //리스트 게시글 정보
	     for (BoardDTO boardDTO : list) {
	    	 System.out.println(boardDTO.getSeq()+"\t"
	    			 			+ boardDTO.getSubject()+"\t"
	    			 			+ boardDTO.getId()+"\t"
	    			 			+ sdf.format(boardDTO.getLogtime()));
	     }
	     
	}

}
