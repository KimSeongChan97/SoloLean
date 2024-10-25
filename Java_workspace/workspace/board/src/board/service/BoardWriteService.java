package board.service;

import java.util.Scanner;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

// 게시글 작성 서비스 클래스
public class BoardWriteService implements Board {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        BoardDTO boardDTO = new BoardDTO(); // 게시글 정보를 담을 DTO 객체 생성

        // 사용자로부터 입력받은 데이터를 DTO에 설정
        System.out.print("아이디 입력 : ");
        boardDTO.setId(scanner.nextLine()); // 아이디 설정
        
        System.out.print("이름 입력 : ");
        boardDTO.setName(scanner.nextLine()); // 이름 설정
        
        System.out.print("제목 입력 : ");
        boardDTO.setSubject(scanner.nextLine()); // 제목 설정
        
        System.out.print("내용 입력 : ");
        boardDTO.setContent(scanner.nextLine()); // 내용 설정

        // DAO 객체를 생성하고 write 메서드를 호출하여 데이터베이스에 저장
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.write(boardDTO);

        // 작성 완료 메시지 출력
        System.out.println("작성하신 글을 등록하였습니다.");
    }
}
