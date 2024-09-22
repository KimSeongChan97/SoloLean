package board.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.dao.BoardDAO;
import com.control.CommandProcess;

public class BoardUpdateService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 파라미터에서 게시글 정보 받아오기
        int seq = Integer.parseInt(request.getParameter("seq"));
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        
        // 디버깅용
        System.out.println("Subject: " + subject);
        System.out.println("Content: " + content);
        
        // Null 또는 빈 값 처리
        if (subject == null || subject.trim().isEmpty()) {
            subject = " "; // Null 대신 빈 값으로 설정
        }
        if (content == null || content.trim().isEmpty()) {
            content = " "; // Null 대신 빈 값으로 설정
        }
        
        // DB에서 게시글 수정
        BoardDAO boardDAO = BoardDAO.getInstance();
        Map<String, String> map = Map.of(
                "seq", String.valueOf(seq),
                "subject", subject,
                "content", content
        );
        
        boardDAO.updateBoard(map);

        // 수정 후 해당 게시글 보기 페이지로 리다이렉트
        return "/board/boardView.do?seq=" + seq;
    }
}
