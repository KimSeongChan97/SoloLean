package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import com.control.CommandProcess;

public class BoardUpdateFormService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 1. 파라미터에서 게시글 정보 받아오기
        // 사용자가 요청한 파라미터 값 중에서 'seq'와 'pg'를 받아옴
        // seq: 게시글 번호, pg: 현재 페이지 번호
        // 예를 들어 사용자가 특정 게시글을 수정하고자 할 때, 해당 글의 번호(seq)와 
        // 현재 보고 있는 페이지(pg)를 서버로 보내주고, 그 값을 이 메서드에서 받아오는 것
        int seq = Integer.parseInt(request.getParameter("seq")); // 게시글 번호를 요청 파라미터로부터 받아와서 정수로 변환
        int pg = Integer.parseInt(request.getParameter("pg"));   // 페이지 번호를 요청 파라미터로부터 받아와서 정수로 변환
        System.out.println(seq + " 번 글, " + pg + " 번 페이지"); // 디버깅을 위한 출력으로 현재 처리 중인 게시글 번호와 페이지 번호를 콘솔에 출력
        
        // 2. DB 연결
        // DAO(Data Access Object)를 사용하여 DB에 접근
        // BoardDAO는 Singleton 패턴을 사용하여 하나의 인스턴스만 생성하고 공유함
        // 이를 통해 데이터베이스 연결 객체를 여러 번 생성하지 않고, 하나의 인스턴스를 재사용할 수 있음
        BoardDAO boardDAO = BoardDAO.getInstance(); // Singleton 패턴으로 생성된 BoardDAO 인스턴스를 가져옴
        
        // 특정 게시글의 내용을 DB에서 가져옴
        // 게시글 번호(seq)를 이용해 해당 게시글의 상세 정보를 가져와서 BoardDTO 객체에 저장
        BoardDTO boardDTO = boardDAO.getBoard(seq); // BoardDAO를 통해 게시글 번호(seq)에 해당하는 게시글 정보를 가져옴

        // request 객체에 현재 페이지 번호(pg)와 게시글 정보를 설정함
        // request.setAttribute()는 JSP에서 해당 데이터를 사용할 수 있게 함
        // 예를 들어, 이후에 JSP에서 ${pg}, ${boardDTO} 같은 방식으로 이 데이터를 사용할 수 있음
        request.setAttribute("pg", pg); // 현재 페이지 번호를 JSP에서 사용하기 위해 설정
        request.setAttribute("boardDTO", boardDTO); // 게시글의 내용을 JSP에서 사용하기 위해 설정
                
        // 3. return "/board/boardUpdateForm.jsp"
        // 게시글 수정 폼으로 이동하기 위해 경로를 리턴함
        // 사용자가 게시글을 수정하려고 할 때, 기존의 내용을 보여주기 위해 JSP 페이지로 이동
        // 이때 앞서 설정한 pg와 boardDTO 정보가 함께 전달됨
        return "/board/boardUpdateForm.jsp"; // 게시글 수정 폼으로 이동하는 경로를 반환
    }
}
