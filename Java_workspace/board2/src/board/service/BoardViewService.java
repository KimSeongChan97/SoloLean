package board.service;

import java.util.Scanner;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

// 특정 게시글 조회 서비스 클래스
public class BoardViewService implements Board {

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        System.out.print("글번호 입력 : ");
        int seq = scan.nextInt(); // 사용자로부터 글번호를 입력받음

        BoardDAO boardDAO = new BoardDAO(); // DAO 객체 생성
        BoardDTO boardDTO = boardDAO.view(seq); // DAO의 view 메서드를 호출하여 특정 글번호의 게시글을 가져옴

        if (boardDTO != null) { // 해당 글번호의 게시글이 존재하는 경우
            System.out.printf("글번호 : %d\t\t아이디 : %s\t\t이름 : %s\n", 
                              boardDTO.getSeq(), 
                              boardDTO.getId(), 
                              boardDTO.getName());
            System.out.printf("날짜 : %s\n", boardDTO.getLogtime());
            System.out.printf("내용 : %s\n", boardDTO.getContent());
        } else {
            // 해당 글번호의 게시글이 존재하지 않는 경우
            System.out.println("해당 글번호의 글이 존재하지 않습니다.");
        }
    }
}
