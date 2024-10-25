package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardUpdateService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 'seq'라는 파라미터로 전달된 게시글 번호를 가져옵니다.
        // request.getParameter("seq")는 문자열로 전달되기 때문에, 이를 Integer.parseInt()로 정수형으로 변환합니다.
        // 이 값은 수정하려는 게시글의 고유번호입니다.
        int seq = Integer.parseInt(request.getParameter("seq"));

        // 사용자가 입력한 새로운 제목을 가져옵니다.
        // 수정 폼에서 'subject'라는 이름으로 전달된 데이터를 가져옵니다.
        String subject = request.getParameter("subject");

        // 사용자가 입력한 새로운 내용을 가져옵니다.
        // 수정 폼에서 'content'라는 이름으로 전달된 데이터를 가져옵니다.
        String content = request.getParameter("content");

        // 수정된 게시글 데이터를 저장할 Map 객체를 생성합니다.
        // 'seq', 'subject', 'content'라는 키와 해당하는 값을 넣어 데이터베이스에 전달할 준비를 합니다.
        Map<String, Object> map = new HashMap<>();
        
        // 'seq'는 게시글의 고유 번호로, 어떤 게시글을 수정할지 지정하기 위한 값입니다.
        map.put("seq", seq);
        
        // 'subject'는 사용자가 입력한 새로운 제목입니다. 수정될 제목 데이터를 저장합니다.
        map.put("subject", subject);
        
        // 'content'는 사용자가 입력한 새로운 내용입니다. 수정될 게시글 본문 데이터를 저장합니다.
        map.put("content", content);

        // BoardDAO의 싱글톤 인스턴스를 가져옵니다.
        // 이 객체는 데이터베이스와 상호작용하여 게시글 정보를 처리합니다.
        BoardDAO boardDAO = BoardDAO.getInstance();

        // 데이터베이스에서 해당 게시글을 업데이트합니다.
        // 'boardUpdate(map)' 메서드를 호출하여, 위에서 준비한 게시글 번호(seq), 제목(subject), 내용(content)을 데이터베이스에 반영합니다.
        boardDAO.boardUpdate(map);

        // 수정 후 반환값은 'none'으로, 이 서비스는 별도의 페이지 이동을 처리하지 않습니다.
        // 필요에 따라 'redirect'나 다른 JSP 페이지로의 이동이 추가될 수 있습니다.
        return "none";
    }

}
